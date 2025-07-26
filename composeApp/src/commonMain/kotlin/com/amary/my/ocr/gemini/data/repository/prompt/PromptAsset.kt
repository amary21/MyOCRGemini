package com.amary.my.ocr.gemini.data.repository.prompt

object PromptFile

fun interface PromptAsset {

    fun name(): String
}

val PromptFile.TextRecognizeExtractor: PromptAsset
    get() = PromptAsset { "prompt_test_recognize_extractor.txt" }