package com.conamobile.daggerhiltexample.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userentity")
class UserEntity(
    @PrimaryKey
    val id: Int,
    val login: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
)