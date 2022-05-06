package com.rodiondev.crocodilewordgame.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.ui.components.Email
import com.rodiondev.crocodilewordgame.ui.components.Password
import com.rodiondev.crocodilewordgame.ui.components.TextFieldState
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewSubState

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.viewState.collectAsState(LoginViewState())

    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(24.dp)){
        with(viewState.value) {
            Text(
                text = when (this.viewSubState) {
                    LoginViewSubState.SignIn -> stringResource(id = R.string.sign_in_title)
                    LoginViewSubState.SignUp -> stringResource(id = R.string.sign_up_title)
                    LoginViewSubState.Forgot -> stringResource(id = R.string.forgot_title)
                },
                style = TextStyle(
                    color = Color.Yellow,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(
                text = when (this.viewSubState) {
                    LoginViewSubState.SignIn -> stringResource(id = R.string.sign_in_subtitle)
                    LoginViewSubState.SignUp -> stringResource(id = R.string.sign_up_subtitle)
                    LoginViewSubState.Forgot -> stringResource(id = R.string.forgot_subtitle)
                },
                style = TextStyle(
                    color = Color.Yellow,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Image(
                painter = painterResource(id = R.drawable.crocodile),
                contentDescription = "Crocodile",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.padding(top = 150.dp))

            Email()
            Password(passwordState = TextFieldState())

            Spacer(modifier = Modifier.padding(top = 12.dp))

            Button(
                onClick = {

                },
            ){
                Text(text = stringResource(id = R.string.sign_in_button),)
            }

        }
    }


}