package com.amary.my.ocr.gemini.feature.ktp

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
import com.amary.my.ocr.gemini.component.button.ButtonCamera
import com.amary.my.ocr.gemini.component.icon.FrameKtp
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
    onBackPressed: () -> Unit = {},
) {
    val permissions: Permissions = providePermissions()
    val scope = rememberCoroutineScope()
    val cameraPermissionState = remember { mutableStateOf(permissions.hasCameraPermission()) }
    val cameraController = remember { mutableStateOf<CameraController?>(null) }

    if (!cameraPermissionState.value) {
        permissions.RequestCameraPermission(
            onGranted = { cameraPermissionState.value = true },
            onDenied = onBackPressed
        )
    }

    Scaffold{
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            CameraPreview(
                modifier = Modifier.fillMaxSize(),
                cameraConfiguration = {
                    setCameraLens(CameraLens.BACK)
                    setFlashMode(FlashMode.OFF)
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

                ButtonCamera(
                    onClick = {
                        scope.launch {
                            when (val result = cameraController.value?.takePicture()) {
                                is ImageCaptureResult.Success -> {
                                    val byteString = result.byteArray.decodeToString()
                                    println("Image Capture Success: $byteString")
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
            }
        }
    }
}