package com.amary.my.ocr.gemini.ui.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.amary.my.ocr.gemini.ui.feature.ktp.navToKtp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable<HomeRoute> {
        HomeScreen(
            onNavigateToKtp = { navController.navToKtp() },
        )
    }
}

@Serializable
@SerialName("home")
data object HomeRoute