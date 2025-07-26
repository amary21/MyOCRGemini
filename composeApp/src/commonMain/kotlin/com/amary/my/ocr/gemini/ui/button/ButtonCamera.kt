package com.amary.my.ocr.gemini.ui.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amary.my.ocr.gemini.ui.icon.CaptureCamera
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonCamera(
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black.copy(alpha = 0.72f),
            contentColor = Color.Black
        )
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = CaptureCamera,
            contentDescription = "Capture Camera",
        )
    }
}

@Preview
@Composable
fun ButtonCameraPreview() {
    ButtonCamera(onClick = {})
}