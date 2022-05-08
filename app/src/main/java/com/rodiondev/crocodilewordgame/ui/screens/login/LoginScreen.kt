package com.rodiondev.crocodilewordgame.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodiondev.crocodilewordgame.R
import com.rodiondev.crocodilewordgame.navigation.NavigationTree
import com.rodiondev.crocodilewordgame.ui.components.*
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginEvent
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewSubState

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.viewState.collectAsState(LoginViewState())
    with(viewState.value) {
        LazyColumn(
            Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
                .padding(24.dp)
        ) {
            item {

                Text(
                    text = when (viewSubState) {
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
                    text = when (viewSubState) {
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

            }
            item {
                Spacer(modifier = Modifier.padding(top = 12.dp))
                Image(
                    painter = painterResource(id = R.drawable.crocodile),
                    contentDescription = "Crocodile",
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(top = 150.dp))
            }
            item {
                when (viewSubState) {
                    LoginViewSubState.SignIn -> SignInFields(
                        this@with,
                        {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        {
                            navController.navigate(NavigationTree.Menu.name)
                        })
                    LoginViewSubState.SignUp -> SignUpFields(
                        this@with,
                        {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        {
                            navController.navigate(NavigationTree.Menu.name)
                        })
                    LoginViewSubState.Forgot -> ForgotFields(
                        this@with,
                        {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        {
                            navController.navigate(NavigationTree.Menu.name)
                        })
                }

            }
        }
    }

}


@Composable
fun SignInFields(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onButtonClicked: () -> Unit
) {
    Email(viewState = viewState, onEmailValueChanged = onEmailChanged)
    Password(viewState = viewState, onPasswordValueChanged = onPasswordChanged)

    Spacer(modifier = Modifier.padding(top = 12.dp))

    Button(
        onClick = onButtonClicked
    ) {
        Text(text = stringResource(id = R.string.sign_in_button))
    }
}


@Composable
fun SignUpFields(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onButtonClicked: () -> Unit
) {
    Email(viewState = viewState, onEmailValueChanged = onEmailChanged)
    Password(viewState = viewState, onPasswordValueChanged = onPasswordChanged)

    Spacer(modifier = Modifier.padding(top = 12.dp))

    Button(
        onClick = onButtonClicked
    ) {
        Text(text = stringResource(id = R.string.sign_in_button))
    }
}

@Composable
fun ForgotFields(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onButtonClicked: () -> Unit
) {
    Email(viewState = viewState, onEmailValueChanged = onEmailChanged)
    Password(viewState = viewState, onPasswordValueChanged = onPasswordChanged)

    Spacer(modifier = Modifier.padding(top = 12.dp))

    Button(
        onClick = onButtonClicked
    ) {
        Text(text = stringResource(id = R.string.sign_in_button))
    }
}