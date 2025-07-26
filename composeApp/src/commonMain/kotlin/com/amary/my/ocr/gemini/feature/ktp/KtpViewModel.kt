package com.amary.my.ocr.gemini.feature.ktp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amary.my.ocr.gemini.domain.GetOCRUseCase
import kotlinx.coroutines.launch

class KtpViewModel(
    private val getOCRUseCase: GetOCRUseCase
): ViewModel() {

    fun getOcr(image: ByteArray) = viewModelScope.launch {
        val result = getOCRUseCase.invoke(image)
        println("RESULT: $result")
    }

}