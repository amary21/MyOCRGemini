package com.amary.my.ocr.gemini.ui.feature.ktp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amary.my.ocr.gemini.ui.component.button.ButtonCamera
import com.amary.my.ocr.gemini.ui.component.button.ButtonFlash
import com.amary.my.ocr.gemini.ui.component.dialog.ErrorDialog
import com.amary.my.ocr.gemini.ui.component.dialog.InfoDialog
import com.amary.my.ocr.gemini.ui.component.dialog.ProgressDialog
import com.amary.my.ocr.gemini.ui.component.icon.FrameKtp
import com.kashif.cameraK.controller.CameraController
import com.kashif.cameraK.enums.CameraLens
import com.kashif.cameraK.enums.Directory
import com.kashif.cameraK.enums.FlashMode
import com.kashif.cameraK.enums.ImageFormat
import com.kashif.cameraK.permissions.Permissions
import com.kashif.cameraK.permissions.providePermissions
import com.kashif.cameraK.result.ImageCaptureResult
import com.kashif.cameraK.ui.CameraPreview
import kotlinx.coroutines.launch

@Composable
fun KtpScreen(
    state: KtpState,
    onBackPressed: () -> Unit = {},
    onCapture: (ByteArray) -> Unit = {},
    onClear: () -> Unit = {},
) {
    val permissions: Permissions = providePermissions()
    val cameraPermissionState = remember { mutableStateOf(permissions.hasCameraPermission()) }

    if (!cameraPermissionState.value) {
        permissions.RequestCameraPermission(
            onGranted = { cameraPermissionState.value = true },
            onDenied = onBackPressed
        )
    }

    Scaffold{
        CameraScreen(
            onCapture = onCapture,
        )

        when (state) {
            is KtpState.Idle -> Unit
            is KtpState.Loading -> {
                ProgressDialog(
                    isShowing = true,
                )
            }
            is KtpState.Success -> {
                InfoDialog(
                    isShowing = true,
                    data = state.data,
                    onDismissRequest = onClear,
                )
            }
            is KtpState.Error -> {
                ErrorDialog(
                    isShowing = true,
                    message = state.message,
                    onDismissRequest = onClear,
                )
            }
        }
    }
}

@Composable
fun CameraScreen(
    onCapture: (ByteArray) -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    val cameraController = remember { mutableStateOf<CameraController?>(null) }
    val flashCameraState = remember { mutableStateOf(FlashMode.OFF) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CameraPreview(
            modifier = Modifier.fillMaxSize(),
            cameraConfiguration = {
                setCameraLens(CameraLens.BACK)
                setFlashMode(flashCameraState.value)
                setImageFormat(ImageFormat.JPEG)
                setDirectory(Directory.PICTURES)
            },
            onCameraControllerReady = { camController ->
                cameraController.value = camController
            }
        )

        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = FrameKtp,
            contentDescription = "Frame KTP",
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            text = "Position KTP card within the frame",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
            ),
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .statusBarsPadding()
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 40.dp),
                text = "Make sure the KTP is clearly visible and all text is readable",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                ButtonCamera(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = {
                        scope.launch {
                            when (val result = cameraController.value?.takePicture()) {
                                is ImageCaptureResult.Success -> {
                                    val byteArray = result.byteArray
                                    println("Image Capture Success: ${byteArray.decodeToString()}")
                                    onCapture(byteArray)
                                }

                                is ImageCaptureResult.Error -> {
                                    println("Image Capture Error: ${result.exception.message}")
                                }

                                null -> {
                                    println("CameraController is null")
                                }
                            }
                        }
                    },
                )

                ButtonFlash(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 28.dp),
                    flashMode = flashCameraState.value,
                ) {
                    if (flashCameraState.value == FlashMode.OFF) {
                        flashCameraState.value = FlashMode.ON
                        cameraController.value?.setFlashMode(FlashMode.ON)

                        cameraController.value?.stopSession()
                    } else {
                        flashCameraState.value = FlashMode.OFF
                        cameraController.value?.setFlashMode(FlashMode.OFF)
                    }
                }
            }
        }
    }
}