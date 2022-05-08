package com.rodiondev.crocodilewordgame.ui.screens.login.models

sealed class LoginEvent {
    object ButtonClicked: LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()

}