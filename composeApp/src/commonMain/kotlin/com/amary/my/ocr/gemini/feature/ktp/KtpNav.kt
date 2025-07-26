package com.amary.my.ocr.gemini.feature.ktp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

internal fun NavGraphBuilder.ktpScreen(navController: NavHostController) {
    composable<KtpRoute> {
        val viewModel = koinViewModel<KtpViewModel>()
        KtpScreen(
            onBackPressed = { navController.popBackStack() },
            onCapture = { viewModel.getOcr(it) }
        )
    }
}

internal fun NavHostController.navToKtp() {
    navigate(KtpRoute)
}


@Serializable
@SerialName("ktp")
data object KtpRoute