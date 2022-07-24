package com.conamobile.daggerhiltexample.di.module

import com.conamobile.daggerhiltexample.networking.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//NetworkModule internetdan ma'lumot olib kelish uchun ishlatiladi
//ApplicationComponent chiqmasa SingletonComponentdan foydalanamiz
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl(): String = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}