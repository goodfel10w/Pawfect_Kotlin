package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

@Entity(tableName = "dislikes")
data class Dislike(
    @PrimaryKey
    @ColumnInfo(name = "dislikeId")
    val dislikeId: Int,

    @ColumnInfo(name = "dislikerAnimalId")
    val dislikerAnimalId: Int,

    @ColumnInfo(name = "dislikeeAnimalId")
    val dislikeeAnimalId: Int,

    @ColumnInfo(name = "date")
    val date: Date
)
