package com.rodiondev.crocodilewordgame.ui.screens.login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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
import com.rodiondev.crocodilewordgame.ui.screens.login.elements.ForgotFields
import com.rodiondev.crocodilewordgame.ui.screens.login.elements.SignInFields
import com.rodiondev.crocodilewordgame.ui.screens.login.elements.SignUpFields
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginEvent
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewState
import com.rodiondev.crocodilewordgame.ui.screens.login.models.LoginViewSubState
import com.rodiondev.crocodilewordgame.ui.theme.AppTheme

/**
 * TODO: add scroll on keyboard open
 */
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.viewState.collectAsState(LoginViewState())
    with(viewState.value) {
        LazyColumn(
            modifier = Modifier
                .background(AppTheme.colors.background)
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
                        color = AppTheme.colors.primaryTint,
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
                        color = AppTheme.colors.primaryTint,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.clickable {
                        loginViewModel.obtainEvent(LoginEvent.TextClicked)
                    }
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
                BaseOutlinedTextField(
                    value = viewState.value.emailValue,
                    labelResourceId = R.string.email_label,
                    onValueChanged = {
                        loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                    }
                )
            }
            item {
                when (viewSubState) {
                    LoginViewSubState.SignIn -> SignInFields(
                        this@with.passwordValue,
                        this@with.isPasswordError,
                        onPasswordChanged = {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        onForgotClicked = {
                            loginViewModel.obtainEvent(LoginEvent.ForgotClicked)
                        },
                        onButtonClicked = {
                            loginViewModel.obtainEvent(LoginEvent.onBottomButtonClicked)
                            navController.navigate(NavigationTree.Menu.name)
                        }

                    )
                    LoginViewSubState.SignUp -> SignUpFields(
                        this@with,
                        onPasswordChanged = {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        onFullNameChanged = {
                            loginViewModel.obtainEvent(LoginEvent.FullNameChanged(it))
                        },
                        onButtonClicked = {
                            navController.navigate(NavigationTree.Menu.name)
                        },
                        onForgotClicked = {
                            loginViewModel.obtainEvent(LoginEvent.ForgotClicked)
                        }

                    )
                    LoginViewSubState.Forgot -> ForgotFields {
                        loginViewModel.obtainEvent(LoginEvent.onBottomButtonClicked)
                        navController.navigate(NavigationTree.Menu.name)
                    }
                }

            }
        }
    }

}


