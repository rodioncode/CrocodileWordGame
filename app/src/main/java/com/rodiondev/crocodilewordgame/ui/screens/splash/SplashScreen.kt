package com.rodiondev.crocodilewordgame.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.rodiondev.crocodilewordgame.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController){

    //TODO: add user token check logic
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(NavigationTree.Login.name)
    })
}