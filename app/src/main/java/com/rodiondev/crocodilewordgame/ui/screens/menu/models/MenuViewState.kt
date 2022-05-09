package com.rodiondev.crocodilewordgame.ui.screens.menu.models

import com.rodiondev.crocodilewordgame.common.Result
import com.rodiondev.crocodilewordgame.network.randomWord.RandomWord


data class MenuViewState(
    val fetchResult: Result<RandomWord>? = null
    /*
    val word : String = "",
    val isLoading : Boolean = false,
    val isError: Boolean = false,*/
)
