package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import androidx.room.ColumnInfo

// Definiert eine Datenbank-Entität mit dem Namen "matches"
@Entity(tableName = "matches")
data class Match(
    // Definiert den Primärschlüssel der Entität
    @PrimaryKey
    @ColumnInfo(name = "matchId") // Legt den Namen der Spalte in der Datenbank fest
    val matchId: Int,

    // Spalteninformationen für die ID des ersten Tiers im Match
    @ColumnInfo(name = "animal1Id")
    val animal1Id: Int,

    // Spalteninformationen für die ID des zweiten Tiers im Match
    @ColumnInfo(name = "animal2Id")
    val animal2Id: Int,

    // Spalteninformationen für das Datum des Matches
    @ColumnInfo(name = "date")
    val date: Date
)
