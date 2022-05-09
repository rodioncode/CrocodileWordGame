package com.rodiondev.crocodilewordgame.ui.screens.login.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.ui.theme.AppTheme

@Composable
fun bottomButtons(
    onButtonClicked: () -> Unit,
    onForgotClicked: () -> Unit,
    buttonText: String
) {
    Row {
        Button(
            onClick = onButtonClicked,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.secondaryTint
            )

        ) {
            Text(
                text = buttonText,
                style = TextStyle(
                    color = AppTheme.colors.secondaryText
                )
            )
        }
        Spacer(modifier = Modifier.padding(start = 12.dp))
        Text(
            text = stringResource(id = R.string.forgot_restore_password_button),
            style = TextStyle(
                color = AppTheme.colors.secondaryTint,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .clickable(enabled = true, onClick = onForgotClicked)
                .align(Alignment.CenterVertically)
        )
    }
}