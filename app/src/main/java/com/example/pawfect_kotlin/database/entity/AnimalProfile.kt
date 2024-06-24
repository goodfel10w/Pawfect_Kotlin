package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "animal_profiles")
data class AnimalProfile(
    @PrimaryKey
    @ColumnInfo(name = "animalProfileId")
    val animalProfileId: Int,

    @ColumnInfo(name = "userProfileId")
    val userProfileId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "gender")
    val gender: Gender,

    @ColumnInfo(name = "images")
    val images: String,

    @ColumnInfo(name = "species")
    val species: String,

    @ColumnInfo(name = "breed")
    val breed: String,

    @ColumnInfo(name = "characteristics")
    val characteristics: String,

    @ColumnInfo(name = "size")
    val size: Double,

    @ColumnInfo(name = "weight")
    val weight: Double,

    @ColumnInfo(name = "intent")
    val intent: Intent,

    @ColumnInfo(name = "description")
    val description: String
)