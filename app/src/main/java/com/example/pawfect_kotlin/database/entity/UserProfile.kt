package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import androidx.room.ColumnInfo

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey
    @ColumnInfo(name = "userProfileId")
    val userProfileId: Int,

    @ColumnInfo(name = "firstName")
    val firstName: String,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @ColumnInfo(name = "birthDate")
    val birthDate: Date,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "isPremium")
    val isPremium: Boolean,

    @ColumnInfo(name = "swipesLeft")
    val swipesLeft: Int,

    @ColumnInfo(name = "address")
    val address: String
)
