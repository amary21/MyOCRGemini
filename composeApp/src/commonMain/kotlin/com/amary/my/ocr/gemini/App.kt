package com.amary.my.ocr.gemini

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.amary.my.ocr.gemini.feature.home.HomeRoute
import com.amary.my.ocr.gemini.feature.home.homeScreen
import com.amary.my.ocr.gemini.feature.ktp.ktpScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navigator = rememberNavController()
        NavHost(
            navController = navigator,
            startDestination = HomeRoute,
        ) {
            homeScreen(navigator)
            ktpScreen(navigator)
        }
    }
}