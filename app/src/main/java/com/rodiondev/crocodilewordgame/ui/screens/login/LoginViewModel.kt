package com.rodiondev.crocodilewordgame.ui.screens.login

import androidx.lifecycle.ViewModel
import com.rodiondev.crocodilewordgame.common.EventHandler
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginEvent
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(): ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow(LoginViewState())

    val viewState : StateFlow<LoginViewState> =  _viewState

    override fun obtainEvent(event: LoginEvent) {
        when(event){
            LoginEvent.ButtonClicked -> TODO()
            is LoginEvent.EmailChanged -> emailChanged(value = event.value)
            is LoginEvent.PasswordChanged -> passwordChanged(value = event.value)
        }
    }

    private fun emailChanged(value : String){
        _viewState.value = _viewState.value.copy(emailValue = value)
    }

    private fun passwordChanged(value : String){
        _viewState.value = _viewState.value.copy(passwordValue = value)
    }
}