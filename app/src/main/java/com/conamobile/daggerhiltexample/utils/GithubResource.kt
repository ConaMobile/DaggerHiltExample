package com.conamobile.daggerhiltexample.utils

import com.conamobile.daggerhiltexample.database.entity.UserEntity

sealed class GithubResource {

    object Loading : GithubResource()
    //    data class Success(val list: List<GithubUser>) : GithubResource()
    data class Success(val list: List<UserEntity>) : GithubResource()
    data class Error(val message: String) : GithubResource()
}