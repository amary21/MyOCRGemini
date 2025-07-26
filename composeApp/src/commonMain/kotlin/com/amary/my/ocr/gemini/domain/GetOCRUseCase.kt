package com.amary.my.ocr.gemini.domain

import com.amary.my.ocr.gemini.data.repository.GeminiRepository
import com.amary.my.ocr.gemini.data.repository.PromptRepository
import com.amary.my.ocr.gemini.data.repository.prompt.PromptFile
import com.amary.my.ocr.gemini.data.repository.prompt.TextRecognizeExtractor
import com.amary.my.ocr.gemini.domain.model.OCRExtractorModel
import com.amary.my.ocr.gemini.domain.model.OCRUiModel
import com.amary.my.ocr.gemini.util.cleanUp
import kotlinx.serialization.json.Json

class GetOCRUseCase(
    private val geminiRepository: GeminiRepository,
    private val promptRepository: PromptRepository
) {
    suspend operator fun invoke(image: ByteArray): OCRUiModel? {
        val prompt = promptRepository.prompt(PromptFile.TextRecognizeExtractor)

        return geminiRepository
            .request(prompt, image)
            .map { it.cleanUp() }
            .map{ Json.decodeFromString<OCRExtractorModel?>(it) }
            .map(::transformToUiModel)
            .getOrNull()
    }

    private fun transformToUiModel(model: OCRExtractorModel?): OCRUiModel {
        if (model == null) return OCRUiModel.Empty

        return OCRUiModel(
            province = model.province,
            regency = model.regency,
            nationalIdentityNumber = model.nationalIdentityNumber,
            placeAndDateOfBirth = model.placeAndDateOfBirth,
            gender = model.gender,
            address = model.address,
            rtRw = model.rtRw,
            villageSuburb = model.villageSuburb,
            district = model.district,
            religion = model.religion,
            maritalStatus = model.maritalStatus,
            occupation = model.occupation,
            citizenship = model.citizenship,
        )
    }
}