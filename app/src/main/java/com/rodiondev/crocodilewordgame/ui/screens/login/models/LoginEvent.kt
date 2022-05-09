package com.rodiondev.crocodilewordgame.ui.screens.login.models

sealed class LoginEvent {
    object TextClicked: LoginEvent()
    object ForgotClicked: LoginEvent()
    object onBottomButtonClicked: LoginEvent()

    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()

    data class FullNameChanged(val value: String): LoginEvent()
    data class PasswordRepeatChanged(val value: String): LoginEvent()

}