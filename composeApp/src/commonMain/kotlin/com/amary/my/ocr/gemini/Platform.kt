package com.amary.my.ocr.gemini

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform