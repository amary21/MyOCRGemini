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
            province = model.province.orEmpty(),
            regency = model.regency.orEmpty(),
            nationalIdentityNumber = model.nationalIdentityNumber.orEmpty(),
            placeAndDateOfBirth = model.placeAndDateOfBirth.orEmpty(),
            gender = model.gender.orEmpty(),
            address = model.address.orEmpty(),
            rtRw = model.rtRw.orEmpty(),
            villageSuburb = model.villageSuburb.orEmpty(),
            district = model.district.orEmpty(),
            religion = model.religion.orEmpty(),
            maritalStatus = model.maritalStatus.orEmpty(),
            occupation = model.occupation.orEmpty(),
            citizenship = model.citizenship.orEmpty(),
        )
    }
}