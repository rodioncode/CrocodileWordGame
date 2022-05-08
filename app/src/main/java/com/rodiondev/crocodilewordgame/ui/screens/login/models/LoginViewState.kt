package com.rodiondev.crocodilewordgame.ui.screens.login.models


enum class LoginViewSubState{
    SignIn, SignUp, Forgot
}
data class LoginViewState(
    val viewSubState: LoginViewSubState = LoginViewSubState.SignIn,
    val emailValue: String = "",
    val passwordValue: String = "",

    // Sign up fields
    val fullNameValue: String = "",
    val passwordRepeatValue: String = "",

    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isLoginProgress: Boolean = false
)
