package com.rodiondev.crocodilewordgame.ui.screens.menu.models

import com.rodiondev.crocodilewordgame.util.Result
import com.rodiondev.crocodilewordgame.data.api.randomWord.RandomWord


data class MenuViewState(
    val fetchResult: Result<RandomWord>? = null
    /*
    val word : String = "",
    val isLoading : Boolean = false,
    val isError: Boolean = false,*/
)
