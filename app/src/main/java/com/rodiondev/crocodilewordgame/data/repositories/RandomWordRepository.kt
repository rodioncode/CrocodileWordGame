package com.rodiondev.crocodilewordgame.data.repositories

import com.rodiondev.crocodilewordgame.data.api.randomWord.RandomWord
import com.rodiondev.crocodilewordgame.data.api.randomWord.RandomWordRemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
import com.rodiondev.crocodilewordgame.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

@Singleton
class RandomWordRepository
@Inject constructor(
    private val remoteData: RandomWordRemoteData
){
    suspend fun getRandomWord(): Flow<Result<RandomWord>?> {
        return flow {
            emit(remoteData.fetchRandomWord())
            emit(Result.loading())
            val result = remoteData.fetchRandomWord()

            //Cache to database if response is successful
            /*if (result.status == Result.Status.SUCCESS) {
                result.data?.results?.let { it ->
                    movieDao.deleteAll(it)
                    movieDao.insertAll(it)
                }
            }*/
            emit(result)
        }.flowOn(Dispatchers.IO)
    }


}