package com.broad.habbit.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


val habitHealthContainerBg = Color(0xff34C759)
val habitWorksContainerBg = Color(0xff5856D6)
val habitLessonContainerBg = Color(0xffFF9500)

val white = Color(0xffFCF1FD)

val green = Color(0xff1BB57C)
val red = Color(0xffE8162C)
val blue = Color(0xff3E79BC)

val backgroundColor = Color(0xff1D2031)
val containerColor = Color(0xff27273F)

val primaryBorderBrush = Brush.horizontalGradient(
    listOf(
        Color(0xffFF32D2),
        Color(0xff6399FF)
    )
)

val emptyBrush = Brush.horizontalGradient(
    listOf(
        Color.Transparent,
        Color.Transparent
    )
)