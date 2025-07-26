package com.amary.my.ocr.gemini.feature.ktp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal fun NavGraphBuilder.ktpScreen(navController: NavHostController) {
    composable<KtpRoute> {
        KtpScreen(
            onBackPressed = { navController.popBackStack() }
        )
    }
}

internal fun NavHostController.navToKtp() {
    navigate(KtpRoute)
}


@Serializable
@SerialName("ktp")
data object KtpRoute