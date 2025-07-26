package com.amary.my.ocr.gemini.util

fun String.cleanUp(): String {
    if (isEmpty()) return ""

    return this
        .replace("```json", "")
        .replace("```", "")
        .replace("\\n", "")
        .replace("\\", "")
        .trim()
}