package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

@Entity(tableName = "matches")
data class Match(
    @PrimaryKey
    @ColumnInfo(name = "matchId")
    val matchId: Int,

    @ColumnInfo(name = "animal1Id")
    val animal1Id: Int,

    @ColumnInfo(name = "animal2Id")
    val animal2Id: Int,

    @ColumnInfo(name = "date")
    val date: Date
)
