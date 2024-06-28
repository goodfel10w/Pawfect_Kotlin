package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

// Definiert eine Datenbank-Entität mit dem Namen "dislikes"
@Entity(tableName = "dislikes")
data class Dislike(
    // Definiert den Primärschlüssel der Entität
    @PrimaryKey
    @ColumnInfo(name = "dislikeId") // Legt den Namen der Spalte in der Datenbank fest
    val dislikeId: Int,

    // Spalteninformationen für die ID des Tiers, das das Dislike gegeben hat
    @ColumnInfo(name = "dislikerAnimalId")
    val dislikerAnimalId: Int,

    // Spalteninformationen für die ID des Tiers, das das Dislike erhalten hat
    @ColumnInfo(name = "dislikeeAnimalId")
    val dislikeeAnimalId: Int,

    // Spalteninformationen für das Datum, an dem das Dislike gegeben wurde
    @ColumnInfo(name = "date")
    val date: Date
)
