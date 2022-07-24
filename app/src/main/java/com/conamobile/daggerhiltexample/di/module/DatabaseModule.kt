package com.conamobile.daggerhiltexample.di.module

import android.content.Context
import androidx.room.Room
import com.conamobile.daggerhiltexample.database.AppDatabase
import com.conamobile.daggerhiltexample.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//DatabaseModule roomdan ma'lumot olib kelish uchun ishlatiladi
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

}