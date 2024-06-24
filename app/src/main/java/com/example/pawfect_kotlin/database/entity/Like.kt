package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

@Entity(tableName = "likes")
data class Like(
    @PrimaryKey
    @ColumnInfo(name = "likeId")
    val likeId: Int,

    @ColumnInfo(name = "likerAnimalId")
    val likerAnimalId: Int,

    @ColumnInfo(name = "likeeAnimalId")
    val likeeAnimalId: Int,

    @ColumnInfo(name = "date")
    val date: Date
)
