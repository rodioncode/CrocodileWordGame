package com.rodiondev.crocodilewordgame.ui.screens.menu.models

sealed class MenuEvent {
    object GenerateNewWord: MenuEvent()
}