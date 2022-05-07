package com.rodiondev.crocodilewordgame.data.request.randomWord

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomWordRemoteData
@Inject
constructor(
    private val randomWordApi : RandomWordApi
)
{
    suspend fun getRandomWord() {
        return flow {
            emit(randomWordApi.getRandomWord())
        }
    }
}