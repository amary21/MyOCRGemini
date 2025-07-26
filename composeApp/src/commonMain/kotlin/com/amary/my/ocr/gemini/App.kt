package com.amary.my.ocr.gemini

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.decodeToImageBitmap
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
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//        ) {
//            Text(
//                modifier = Modifier.padding(bottom = 24.dp),
//                text = "OCR Gemini"
//            )
//            Button(onClick = { showContent = !showContent }) {
//                Text("KTP")
//            }
//            Button(onClick = { showContent = !showContent }) {
//                Text("STNK")
//            }
//        }
        val permissions: Permissions = providePermissions()
        val scope = rememberCoroutineScope()

        // Initialize and check permissions
        val cameraPermissionState = remember { mutableStateOf(permissions.hasCameraPermission()) }
        val storagePermissionState = remember { mutableStateOf(permissions.hasStoragePermission()) }

        // Request permissions if needed
        if (!cameraPermissionState.value) {
            permissions.RequestCameraPermission(
                onGranted = { cameraPermissionState.value = true },
                onDenied = { println("Camera Permission Denied") }
            )
        }

        if (!storagePermissionState.value) {
            permissions.RequestStoragePermission(
                onGranted = { storagePermissionState.value = true },
                onDenied = { println("Storage Permission Denied") }
            )
        }

        val cameraController = remember { mutableStateOf<CameraController?>(null) }

        // Configure plugins if needed
//        val imageSaverPlugin = rememberImageSaverPlugin(
//            config = ImageSaverConfig(
//                isAutoSave = false,
//                prefix = "MyApp",
//                directory = Directory.PICTURES,
//                customFolderName = "MyAppPhotos"  // Android only
//            )
//        )
//
//        val qrScannerPlugin = rememberQRScannerPlugin(coroutineScope = coroutineScope)

        // Set up QR code detection
//        LaunchedEffect(Unit) {
//            qrScannerPlugin.getQrCodeFlow().distinctUntilChanged()
//                .collectLatest { qrCode ->
//                    println("QR Code Detected: $qrCode")
//                    qrScannerPlugin.pauseScanning()
//                }
//        }

        CameraPreview(
            modifier = Modifier.fillMaxSize(),
            cameraConfiguration = {
                setCameraLens(CameraLens.BACK)
                setFlashMode(FlashMode.OFF)
                setImageFormat(ImageFormat.JPEG)
                setDirectory(Directory.PICTURES)
//                addPlugin(imageSaverPlugin)
//                addPlugin(qrScannerPlugin)
            },
            onCameraControllerReady = {
                cameraController.value = it
//                qrScannerPlugin.startScanning()
            }
        )

        // Display your custom camera UI once controller is ready
//        cameraController.value?.let { controller ->
//            CameraScreen(cameraController = controller, imageSaverPlugin)
//        }

        Button(
            onClick = {
                scope.launch {
                    when (val result = cameraController.value?.takePicture()) {
                        is ImageCaptureResult.Success -> {
                            // Handle the captured image
                            val bitmap = result.byteArray.decodeToImageBitmap()

                            // Manually save the image if auto-save is disabled
//                            if (!imageSaverPlugin.config.isAutoSave) {
//                                imageSaverPlugin.saveImage(
//                                    byteArray = result.byteArray,
//                                    imageName = "Photo_${System.currentTimeMillis()}"
//                                )
//                            }
                        }
                        is ImageCaptureResult.Error -> {
                            println("Image Capture Error: ${result.exception.message}")
                        }

                        null -> {
                            println("CameraController is null")
                        }
                    }
                }
            }
        ) {
            Text("Capture")
        }
    }
}