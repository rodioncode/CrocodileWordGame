package com.rodiondev.crocodilewordgame.data.api.randomWord

import retrofit2.Response
import retrofit2.http.GET

interface RandomWordApi {

    @GET("./words.json/randomWord")
    suspend fun getRandomWord(): Response<RandomWord>

    @GET("./words.json/randomWords")
    suspend fun getArrayOfRandomWords(): Response<RandomWordsResponse>
}