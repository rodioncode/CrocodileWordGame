package com.rodiondev.crocodilewordgame.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val background: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val primaryTint: Color,
    val secondaryTint: Color
)

val lightPalette = Colors(
    background = Color(0xFF287233),
    primaryText = Color.Black,
    secondaryText = Color.White,
    primaryTint = Color(0xFFADFF2F),
    secondaryTint = Color(0xFFF28C28)
)
