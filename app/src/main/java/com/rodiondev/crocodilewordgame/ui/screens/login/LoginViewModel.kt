package com.rodiondev.crocodilewordgame.ui.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.rodiondev.crocodilewordgame.data.repositories.FirebaseRepository
import com.rodiondev.crocodilewordgame.util.EventHandler
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginEvent
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewSubState
import com.rodiondev.crocodilewordgame.util.EMAIL_VALIDATION_REGEX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(
    private val firebaseRepository: FirebaseRepository
): ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow(LoginViewState())

    val viewState : StateFlow<LoginViewState> =  _viewState

    override fun obtainEvent(event: LoginEvent) {
        when(event){
            LoginEvent.TextClicked -> switchFields()
            LoginEvent.ForgotClicked -> forgotClicked()
            is LoginEvent.EmailChanged -> emailChanged(value = event.value)
            is LoginEvent.PasswordChanged -> passwordChanged(value = event.value)
            is LoginEvent.FullNameChanged -> fullNameChanged(value = event.value)
            is LoginEvent.PasswordRepeatChanged -> passwordRepeatChanged(value = event.value)
            LoginEvent.onBottomButtonClicked -> onBottomButtonClicked()
        }
    }

    private fun onBottomButtonClicked() {
        when(_viewState.value.viewSubState){
            LoginViewSubState.SignIn -> onSignInClicked()
            LoginViewSubState.SignUp -> onSignUpClicked()
            LoginViewSubState.Forgot -> onForgotClicked()
        }
    }

    private fun onForgotClicked() {
        with(_viewState.value){
            firebaseRepository.sendForgotPassword(emailValue)
        }
    }

    private fun onSignUpClicked() {
        with(_viewState.value){
            firebaseRepository.signUpUser(
                email = emailValue,
                password = passwordValue,
                fullName = fullNameValue
            )
        }
    }

    private fun onSignInClicked() {
        with(_viewState.value){
            firebaseRepository.signInUser(email = emailValue, password = passwordValue)
        }
    }

    private fun switchFields() {
        when(_viewState.value.viewSubState){
            LoginViewSubState.SignIn -> switchToSignUp()
            LoginViewSubState.SignUp -> switchToSignIn()
            LoginViewSubState.Forgot -> switchToSignIn()
        }
    }

    private fun switchToSignUp() {
        _viewState.value = _viewState.value.copy(viewSubState = LoginViewSubState.SignUp)
    }

    private fun switchToSignIn() {
        _viewState.value = _viewState.value.copy(viewSubState = LoginViewSubState.SignIn)
    }

    private fun switchToForgot() {
        _viewState.value = _viewState.value.copy(viewSubState = LoginViewSubState.Forgot)
    }

    private fun forgotClicked() {
        switchToForgot()
    }

    private fun emailChanged(value : String){
        if(isEmailValid(value)){
            _viewState.value = _viewState.value.copy(emailValue = value, isEmailError = false)
        } else {
            _viewState.value = _viewState.value.copy(emailValue = value, isEmailError = true)
        }
    }

    private fun passwordChanged(value : String){
        if(isPasswordValid(value)){
            _viewState.value = _viewState.value.copy(passwordValue = value, isPasswordError = false)
        } else {
            _viewState.value = _viewState.value.copy(passwordValue = value, isPasswordError = true)
        }
    }

    private fun fullNameChanged(value : String){
        _viewState.value = _viewState.value.copy(fullNameValue = value)
    }

    private fun passwordRepeatChanged(value : String){
        _viewState.value = _viewState.value.copy(passwordRepeatValue = value)

    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }
}