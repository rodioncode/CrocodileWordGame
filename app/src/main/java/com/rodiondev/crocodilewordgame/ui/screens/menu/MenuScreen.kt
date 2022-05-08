package com.rodiondev.crocodilewordgame.ui.screens.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuEvent
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuViewState

@Composable
fun MenuScreen(
    navController: NavController,
    menuViewModel: MenuViewModel
) {
    val viewState = menuViewModel.viewState.collectAsState(MenuViewState())
    Column {
        Text(
            text = viewState.value.word ?: "",
            style = TextStyle(
                fontSize = 24.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Button(
            onClick = {
                menuViewModel.obtainEvent(MenuEvent.GenerateNewWord)
            }
        ){
            Text(text = "Generate new word")
        }
    }


}