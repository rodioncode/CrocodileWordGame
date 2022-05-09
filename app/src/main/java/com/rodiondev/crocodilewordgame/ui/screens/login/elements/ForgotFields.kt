package com.rodiondev.crocodilewordgame.ui.screens.login.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.ui.theme.AppTheme

@Composable
fun ForgotFields(
    onButtonClicked: () -> Unit
) {
    Spacer(modifier = Modifier.padding(top = 12.dp))
    Button(
        onClick = onButtonClicked,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.secondaryTint
        )

    ) {
        Text(
            text = stringResource(id = R.string.forgot_restore_password_button),
            style = TextStyle(
                color = AppTheme.colors.secondaryText
            )
        )
    }
}