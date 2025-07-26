package com.amary.my.ocr.gemini.ui.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amary.my.ocr.gemini.component.icon.FlashOFF
import com.amary.my.ocr.gemini.component.icon.FlashON
import com.amary.my.ocr.gemini.ui.component.icon.CaptureCamera
import com.kashif.cameraK.enums.FlashMode
import io.ktor.client.request.invoke
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonFlash(
    flashMode: FlashMode = FlashMode.OFF,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.70f),
            contentColor = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .size(43.dp)
                .clip(CircleShape)
                .background(Color(0xFF050402).copy(alpha = 0.70f)),
            contentAlignment = Alignment.Center,
            content = {
                Image(
                    modifier = Modifier.size(20.dp),
                    imageVector = if (flashMode == FlashMode.ON) FlashON else FlashOFF,
                    contentDescription = "Capture Camera",
                )
            }
        )
    }
}

@Preview
@Composable
fun ButtonFlashPreview() {
    ButtonFlash(onClick = {})
}