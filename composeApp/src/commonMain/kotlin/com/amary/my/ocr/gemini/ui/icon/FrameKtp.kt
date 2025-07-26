package com.amary.my.ocr.gemini.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FrameKtp: ImageVector
    get() {
        if (_FrameKtp != null) {
            return _FrameKtp!!
        }
        _FrameKtp = ImageVector.Builder(
            name = "FrameKtp",
            defaultWidth = 375.dp,
            defaultHeight = 788.dp,
            viewportWidth = 375f,
            viewportHeight = 788f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.72f
            ) {
                moveTo(375f, 788f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                horizontalLineTo(375f)
                verticalLineTo(788f)
                close()
                moveTo(32f, 176f)
                curveTo(23.16f, 176f, 16f, 183.16f, 16f, 192f)
                verticalLineTo(380f)
                curveTo(16f, 388.84f, 23.16f, 396f, 32f, 396f)
                horizontalLineTo(343f)
                curveTo(351.84f, 396f, 359f, 388.84f, 359f, 380f)
                verticalLineTo(192f)
                curveTo(359f, 183.16f, 351.84f, 176f, 343f, 176f)
                horizontalLineTo(32f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 6f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(32f, 179f)
                lineTo(343f, 179f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 356f, 192f)
                lineTo(356f, 380f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 343f, 393f)
                lineTo(32f, 393f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 380f)
                lineTo(19f, 192f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 32f, 179f)
                close()
            }
        }.build()

        return _FrameKtp!!
    }

@Suppress("ObjectPropertyName")
private var _FrameKtp: ImageVector? = null
