package com.amary.my.ocr.gemini.ui.feature.ktp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amary.my.ocr.gemini.domain.GetOCRUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class KtpViewModel(
    private val getOCRUseCase: GetOCRUseCase
): ViewModel() {

    private val _state = MutableStateFlow<KtpState>(KtpState.Idle)
    val state get() = _state.asStateFlow()

    fun getOcr(image: ByteArray) = viewModelScope.launch {
        _state.value = KtpState.Loading

        val result = getOCRUseCase.invoke(image)
        result.onSuccess {
            _state.value = KtpState.Success(it)
        }.onFailure {
            _state.value = KtpState.Error(it.message.orEmpty())
        }
    }

    fun onClear() {
        _state.value = KtpState.Idle
    }
}