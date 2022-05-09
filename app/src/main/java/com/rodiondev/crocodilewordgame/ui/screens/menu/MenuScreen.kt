package com.rodiondev.crocodilewordgame.ui.screens.menu

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodiondev.crocodilewordgame.common.Result
import com.rodiondev.crocodilewordgame.network.randomWord.RandomWord
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuEvent
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuViewState
import com.rodiondev.crocodilewordgame.ui.theme.AppTheme

@Composable
fun MenuScreen(
    navController: NavController,
    menuViewModel: MenuViewModel
) {
    val viewState = menuViewModel.viewState.collectAsState(MenuViewState())
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        with(viewState.value){
            if(fetchResult != null){
                when(fetchResult.status){
                    Result.Status.SUCCESS -> onSuccess(fetchResult.data!!.randomWord)
                    Result.Status.ERROR -> onError()
                    Result.Status.LOADING -> onLoading()
                }
            } else{
                Text(
                    text = "Press the button to start",
                    style = TextStyle(
                        fontSize = 24.sp
                    )
                )
            }

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


}

@Composable
private fun onLoading() {
    CircularProgressIndicator()
}

@Composable
private fun onError() {
    Text(
        text = "Error",
        style = TextStyle(
            color = AppTheme.colors.errorColor,
            fontSize = 24.sp,
        )
    )
}

@Composable
private fun onSuccess(word: String) {
    Text(
        text = word,
        style = TextStyle(
            fontSize = 24.sp
        )
    )
}