package com.rodiondev.crocodilewordgame.data.request.randomWord

import com.google.gson.annotations.SerializedName

data class RandomWordsResponse(
    val randomWords: List<RandomWord>
)

data class RandomWord(
    @SerializedName("word")
    val randomWord: String
)
