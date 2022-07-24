package com.conamobile.daggerhiltexample.repository

import com.conamobile.daggerhiltexample.database.dao.UserDao
import com.conamobile.daggerhiltexample.database.entity.UserEntity
import com.conamobile.daggerhiltexample.networking.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(
    //internet
    private val apiService: ApiService,
    //local
    private val userDao: UserDao,
) {

    suspend fun getUsers() = flow { emit(apiService.getUsers()) }

    suspend fun insertUsers(list: List<UserEntity>) = userDao.insertUsers(list)

    suspend fun getDbUsers() = userDao.getUsers()
}