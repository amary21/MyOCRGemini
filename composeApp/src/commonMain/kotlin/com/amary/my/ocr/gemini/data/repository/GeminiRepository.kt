package com.amary.my.ocr.gemini.data.repository

import com.amary.my.ocr.gemini.data.api.GeminiApi
import com.amary.my.ocr.gemini.data.entity.GeminiResponse
import com.amary.my.ocr.gemini.data.repository.request.GeminiRequestBody

interface GeminiRepository {
    suspend fun request(prompt: String, image: ByteArray): Result<String>
}

class GeminiRepositoryImpl(
    private val api: GeminiApi
) : GeminiRepository {
    override suspend fun request(prompt: String, image: ByteArray): Result<String> {
        val reqBody = GeminiRequestBody.create(prompt, image)
        return api.extractInfo(reqBody).map(::extractFirstPromptResult)
    }

    private fun extractFirstPromptResult(response: GeminiResponse) =
        response.candidates
            .firstOrNull()
            ?.content
            ?.parts
            ?.firstOrNull()
            ?.text
            .orEmpty()
}