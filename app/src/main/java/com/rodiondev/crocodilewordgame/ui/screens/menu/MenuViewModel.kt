package com.rodiondev.crocodilewordgame.ui.screens.menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodiondev.crocodilewordgame.common.EventHandler
import com.rodiondev.crocodilewordgame.repository.RandomWordRepository
import com.rodiondev.crocodilewordgame.ui.screens.login.models.MenuEvent
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel
@Inject
constructor(
    private val randomWordRepository: RandomWordRepository
): ViewModel(), EventHandler<MenuEvent> {

    private val _viewState = MutableStateFlow(MenuViewState())

    val viewState : StateFlow<MenuViewState> =  _viewState

    init{
        fetchUsers()
    }

    override fun obtainEvent(event: MenuEvent) {
        TODO("Not yet implemented")
    }


    fun fetchUsers(){
        viewModelScope.launch {
            randomWordRepository.getRandomWord().collect{
                _viewState.value.word = it.toString()
                Log.i("API_CHECK", _viewState.value.word)
            }
        }
    }

}