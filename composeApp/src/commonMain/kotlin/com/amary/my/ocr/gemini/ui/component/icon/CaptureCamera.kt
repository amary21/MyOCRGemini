package com.amary.my.ocr.gemini.ui.component.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val CaptureCamera: ImageVector
    get() {
        if (_CaptureCamera != null) {
            return _CaptureCamera!!
        }
        _CaptureCamera = ImageVector.Builder(
            name = "CaptureCamera",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(50f, 50f)
                moveToRelative(-40f, 0f)
                arcToRelative(40f, 40f, 0f, isMoreThanHalf = true, isPositiveArc = true, 80f, 0f)
                arcToRelative(40f, 40f, 0f, isMoreThanHalf = true, isPositiveArc = true, -80f, 0f)
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f
            ) {
                moveTo(50f, 50f)
                moveToRelative(-49f, 0f)
                arcToRelative(49f, 49f, 0f, isMoreThanHalf = true, isPositiveArc = true, 98f, 0f)
                arcToRelative(49f, 49f, 0f, isMoreThanHalf = true, isPositiveArc = true, -98f, 0f)
            }
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(45.39f, 37.79f)
                curveTo(45.21f, 37.79f, 45.04f, 37.84f, 44.88f, 37.93f)
                curveTo(44.73f, 38.02f, 44.6f, 38.15f, 44.51f, 38.31f)
                lineTo(42.48f, 41.99f)
                lineTo(41.82f, 42.04f)
                lineTo(41.66f, 42.06f)
                curveTo(40.51f, 42.16f, 39.42f, 42.65f, 38.57f, 43.44f)
                curveTo(37.72f, 44.24f, 37.17f, 45.3f, 36.99f, 46.45f)
                curveTo(36.74f, 48.17f, 36.5f, 50.01f, 36.5f, 51.89f)
                curveTo(36.5f, 53.78f, 36.74f, 55.62f, 36.99f, 57.34f)
                curveTo(37.17f, 58.49f, 37.72f, 59.55f, 38.57f, 60.35f)
                curveTo(39.42f, 61.14f, 40.51f, 61.63f, 41.66f, 61.73f)
                curveTo(44.4f, 61.97f, 47.19f, 62.21f, 50f, 62.21f)
                curveTo(52.81f, 62.21f, 55.6f, 61.97f, 58.34f, 61.73f)
                curveTo(59.49f, 61.63f, 60.58f, 61.14f, 61.43f, 60.35f)
                curveTo(62.28f, 59.55f, 62.83f, 58.49f, 63.01f, 57.34f)
                curveTo(63.26f, 55.62f, 63.5f, 53.78f, 63.5f, 51.89f)
                curveTo(63.5f, 50.01f, 63.26f, 48.17f, 63.01f, 46.45f)
                curveTo(62.83f, 45.3f, 62.28f, 44.24f, 61.43f, 43.44f)
                curveTo(60.58f, 42.65f, 59.49f, 42.16f, 58.34f, 42.06f)
                lineTo(58.2f, 42.05f)
                lineTo(57.52f, 41.99f)
                lineTo(55.49f, 38.31f)
                curveTo(55.4f, 38.15f, 55.27f, 38.02f, 55.12f, 37.93f)
                curveTo(54.96f, 37.84f, 54.79f, 37.79f, 54.61f, 37.79f)
                horizontalLineTo(45.39f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(50f, 56.53f)
                curveTo(53.34f, 56.53f, 55.23f, 54.65f, 55.23f, 51.3f)
                curveTo(55.23f, 47.96f, 53.35f, 46.08f, 50f, 46.08f)
                curveTo(46.65f, 46.08f, 44.77f, 47.96f, 44.77f, 51.31f)
                curveTo(44.77f, 54.65f, 46.65f, 56.53f, 50f, 56.53f)
                close()
            }
        }.build()

        return _CaptureCamera!!
    }

@Suppress("ObjectPropertyName")
private var _CaptureCamera: ImageVector? = null
