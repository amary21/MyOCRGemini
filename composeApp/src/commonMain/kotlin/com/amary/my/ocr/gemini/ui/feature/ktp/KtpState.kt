package com.amary.my.ocr.gemini.ui.feature.ktp

import com.amary.my.ocr.gemini.domain.model.OCRUiModel

sealed class KtpState {
    object Idle: KtpState()
    object Loading: KtpState()
    data class Success(val data: OCRUiModel): KtpState()
    data class Error(val message: String): KtpState()
}