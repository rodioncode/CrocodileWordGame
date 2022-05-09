package com.rodiondev.crocodilewordgame.ui.screens.login.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.ui.components.BaseOutlinedTextField
import com.rodiondev.crocodilewordgame.ui.components.Password
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState

@Composable
fun SignUpFields(
    viewState: LoginViewState,
    onPasswordChanged: (String) -> Unit,
    onFullNameChanged: (String) -> Unit,
    onButtonClicked: () -> Unit,
    onForgotClicked: () -> Unit

) {
    Password(
        value = viewState.passwordValue,
        onPasswordValueChanged = onPasswordChanged,
        isError = viewState.isPasswordError
    )
    BaseOutlinedTextField(
        value = viewState.fullNameValue,
        labelResourceId = R.string.sign_up_full_name,
        onValueChanged = onFullNameChanged
    )
    Spacer(modifier = Modifier.padding(top = 12.dp))

    bottomButtons(onButtonClicked, onForgotClicked, stringResource(id = R.string.sign_up_button))

}