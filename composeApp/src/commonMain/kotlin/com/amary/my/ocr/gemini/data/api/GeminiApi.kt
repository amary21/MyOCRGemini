package com.amary.my.ocr.gemini.data.api

import com.amary.my.ocr.gemini.data.entity.GeminiResponse
import com.amary.my.ocr.gemini.lib.NetworkClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface GeminiApi {
    suspend fun extractInfo(request: String): Result<GeminiResponse>

    companion object Companion {
        private const val MODEL_VERSION = "gemini-2.5-flash"
        private const val URL = "v1beta/models/$MODEL_VERSION:generateContent?key=XXX"

        fun create() = object : GeminiApi {
            override suspend fun extractInfo(request: String): Result<GeminiResponse> {
                return runCatching {
                    NetworkClient
                        .create
                        .post("${NetworkClient.GeminiBaseUrl}$URL") { setBody(request) }
                        .body()
                }
            }
        }
    }
}