package com.rodiondev.crocodilewordgame.ui.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodiondev.crocodilewordgame.util.EventHandler
import com.rodiondev.crocodilewordgame.data.repositories.RandomWordRepository
import com.rodiondev.crocodilewordgame.ui.screens.menu.models.MenuEvent
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

    override fun obtainEvent(event: MenuEvent) {
        when(event){
            MenuEvent.GenerateNewWord -> fetchUsers()
        }
    }


    private fun fetchUsers(){
        viewModelScope.launch {
            randomWordRepository.getRandomWord().collect{
                _viewState.value = _viewState.value.copy(fetchResult = it)
            }
        }
    }

}