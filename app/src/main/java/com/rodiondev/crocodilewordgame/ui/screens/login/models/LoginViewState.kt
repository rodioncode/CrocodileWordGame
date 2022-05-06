package com.rodiondev.crocodilewordgame.ui.screens.login.models

enum class LoginViewSubState{
    SignIn, SignUp, Forgot
}
data class LoginViewState(
    val viewSubState: LoginViewSubState = LoginViewSubState.SignIn,
    val emailValue: String = "",
    val passwordValue: String = "",
    val fullNameValue: String = "",
    val isLoginProgress: Boolean = false
)
