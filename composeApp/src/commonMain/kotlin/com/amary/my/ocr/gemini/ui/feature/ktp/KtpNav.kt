package com.amary.my.ocr.gemini.ui.feature.ktp

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

internal fun NavGraphBuilder.ktpScreen(navController: NavHostController) {
    composable<KtpRoute> {
        val viewModel = koinViewModel<KtpViewModel>()
        val state by viewModel.state.collectAsState()

        KtpScreen(
            state = state,
            onBackPressed = { navController.popBackStack() },
            onCapture = { viewModel.getOcr(it) },
            onClear = { viewModel.onClear() }
        )
    }
}

internal fun NavHostController.navToKtp() {
    navigate(KtpRoute)
}


@Serializable
@SerialName("ktp")
data object KtpRoute