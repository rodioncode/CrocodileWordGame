package com.rodiondev.crocodilewordgame.ui.theme

import androidx.compose.ui.graphics.Color


/*
    All colors and palette are temporary
    Design will be changed soon

 */
data class Colors(
    val background: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val primaryTint: Color,
    val secondaryTint: Color,
    val errorColor: Color
)

val lightPalette = Colors(
    background = Color(0xFF287233),
    primaryText = Color.Black,
    secondaryText = Color.White,
    primaryTint = Color(0xFFADFF2F),
    secondaryTint = Color(0xFFF28C28),
    errorColor = Color.Red
)
