package com.rodiondev.crocodilewordgame.ui.screens.menu

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuViewState

@Composable
fun MenuScreen(
    navController: NavController,
    menuViewModel: MenuViewModel
) {
    val viewState = menuViewModel.viewState.collectAsState(MenuViewState())

    Button(
        onClick = {

        }
    ){
        Text(text = "Generate new word")
    }

}