package com.rodiondev.crocodilewordgame.ui.screens.login.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.ui.components.Password

@Composable
fun SignInFields(
    value: String,
    isPasswordError: Boolean,
    onPasswordChanged: (String) -> Unit,
    onButtonClicked: () -> Unit,
    onForgotClicked: () -> Unit
) {

    Password(
        value = value,
        isError = isPasswordError,
        onPasswordValueChanged = onPasswordChanged
    )

    Spacer(modifier = Modifier.padding(top = 12.dp))
    bottomButtons(onButtonClicked, onForgotClicked, stringResource(id = R.string.sign_in_button))

}