package com.rodiondev.crocodilewordgame.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodiondev.crocodilewordgame.navigation.NavigationTree
import com.rodiondev.crocodilewordgame.ui.screens.login.LoginScreen
import com.rodiondev.crocodilewordgame.ui.screens.login.LoginViewModel
import com.rodiondev.crocodilewordgame.ui.screens.menu.MenuScreen
import com.rodiondev.crocodilewordgame.ui.screens.menu.MenuViewModel
import com.rodiondev.crocodilewordgame.ui.screens.splash.SplashScreen

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {
        composable(NavigationTree.Splash.name) { SplashScreen(navController = navController) }
        composable(NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                navController = navController,
                loginViewModel = loginViewModel
            ) }
        composable(NavigationTree.Menu.name) {
            val menuViewModel = hiltViewModel<MenuViewModel>()
            MenuScreen(
            navController = navController,
            menuViewModel = menuViewModel
        ) }
    }
}