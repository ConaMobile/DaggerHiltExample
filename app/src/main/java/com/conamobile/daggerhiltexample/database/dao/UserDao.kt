package com.conamobile.daggerhiltexample.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.conamobile.daggerhiltexample.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    //onConflict = REPLACE -> qayta ilovani ishga tushurganimizda
    // ma'lumotlar ustiga yukalnsa oldingi ma'lumotni yangisi bilan almashtiradi
    @Insert(onConflict = REPLACE)
    suspend fun insertUsers(list: List<UserEntity>)

    @Query("select * from userentity")
    suspend fun getUsers(): List<UserEntity>
}