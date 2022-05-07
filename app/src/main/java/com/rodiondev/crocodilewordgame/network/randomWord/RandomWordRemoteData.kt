package com.rodiondev.crocodilewordgame.network.randomWord

import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import com.rodiondev.crocodilewordgame.common.Result
import com.rodiondev.crocodilewordgame.util.ErrorUtils

class RandomWordRemoteData
@Inject
constructor(
    private val retrofit: Retrofit
) {

    suspend fun fetchRandomWord(): Result<RandomWord> {
        val randomWordApi = retrofit.create(RandomWordApi::class.java);
        return getResponse(
            request = { randomWordApi.getRandomWord() },
            defaultErrorMessage = "Error fetching Random word")

    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }
}