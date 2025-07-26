package com.amary.my.ocr.gemini.di

import com.amary.my.ocr.gemini.data.api.GeminiApi
import com.amary.my.ocr.gemini.data.repository.GeminiRepository
import com.amary.my.ocr.gemini.data.repository.GeminiRepositoryImpl
import com.amary.my.ocr.gemini.data.repository.PromptRepository
import com.amary.my.ocr.gemini.data.repository.PromptRepositoryImpl
import com.amary.my.ocr.gemini.domain.GetOCRUseCase
import com.amary.my.ocr.gemini.feature.ktp.KtpViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<GeminiApi> { GeminiApi.create() }
    singleOf(::PromptRepositoryImpl) bind PromptRepository::class
    factoryOf(::GeminiRepositoryImpl) bind GeminiRepository::class

    factoryOf(::GetOCRUseCase)

    viewModelOf(::KtpViewModel)
}