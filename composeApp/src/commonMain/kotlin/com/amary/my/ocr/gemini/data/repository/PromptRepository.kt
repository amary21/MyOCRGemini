package com.amary.my.ocr.gemini.data.repository

import com.amary.my.ocr.gemini.data.repository.prompt.PromptAsset
import gemini.composeapp.generated.resources.Res

interface PromptRepository {
    suspend fun prompt(file: PromptAsset): String
}

class PromptRepositoryImpl : PromptRepository {
    override suspend fun prompt(file: PromptAsset): String {
        return Res.readBytes("files/${file.name()}").decodeToString()
    }

}
