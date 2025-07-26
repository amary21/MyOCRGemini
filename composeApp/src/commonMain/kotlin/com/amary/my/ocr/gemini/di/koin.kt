package com.amary.my.ocr.gemini.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(appModule)
}