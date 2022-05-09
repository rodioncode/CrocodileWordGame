package com.rodiondev.crocodilewordgame.di

import com.rodiondev.crocodilewordgame.util.BASE_URL
import com.rodiondev.crocodilewordgame.BuildConfig
import com.rodiondev.crocodilewordgame.data.api.randomWord.RandomWordApi
import com.rodiondev.crocodilewordgame.data.api.randomWord.RandomWordRemoteData
import com.rodiondev.crocodilewordgame.util.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl = BASE_URL

    @Provides
    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor(BuildConfig.API_KEY))
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideRandomWordApi(retrofit : Retrofit) : RandomWordApi = retrofit.create(RandomWordApi::class.java)

    @Provides
    @Singleton
    fun provideRandomWordRemoteData(retrofit: Retrofit) : RandomWordRemoteData = RandomWordRemoteData(retrofit)

}