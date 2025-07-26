package com.amary.my.ocr.gemini.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onNavigateToKtp: () -> Unit = {},
    onNavigateToStnk: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(bottom = 24.dp),
            text = "OCR Gemini"
        )
        Button(onClick = onNavigateToKtp ) {
            Text("KTP")
        }
        Button(onClick = onNavigateToStnk ) {
            Text("STNK")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}