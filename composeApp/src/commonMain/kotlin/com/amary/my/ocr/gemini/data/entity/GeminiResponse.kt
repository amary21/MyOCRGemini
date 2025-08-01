package com.amary.my.ocr.gemini.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeminiResponse(
    @SerialName("candidates") val candidates: List<GeminiCandidate> = emptyList(),
    @SerialName("error") val error: GeminiError? = null
)