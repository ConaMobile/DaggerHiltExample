package com.conamobile.daggerhiltexample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.conamobile.daggerhiltexample.database.dao.UserDao
import com.conamobile.daggerhiltexample.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}