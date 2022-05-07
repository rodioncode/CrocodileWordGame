package com.rodiondev.crocodilewordgame.repository

import com.rodiondev.crocodilewordgame.data.request.randomWord.RandomWordRemoteData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomWordRepository
@Inject constructor(
    private val remoteData: RandomWordRemoteData
){
    suspend fun getRandomWord() = remoteData.getRandomWord()
}