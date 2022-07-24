package com.conamobile.daggerhiltexample.networking

import com.conamobile.daggerhiltexample.models.GithubUser
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<GithubUser>>
}