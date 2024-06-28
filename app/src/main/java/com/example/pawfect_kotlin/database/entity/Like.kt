package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

// Definiert eine Datenbank-Entität mit dem Namen "likes"
@Entity(tableName = "likes")
data class Like(
    // Definiert den Primärschlüssel der Entität
    @PrimaryKey
    @ColumnInfo(name = "likeId") // Legt den Namen der Spalte in der Datenbank fest
    val likeId: Int,

    // Spalteninformationen für die ID des Tiers, das das Like gegeben hat
    @ColumnInfo(name = "likerAnimalId")
    val likerAnimalId: Int,

    // Spalteninformationen für die ID des Tiers, das das Like erhalten hat
    @ColumnInfo(name = "likeeAnimalId")
    val likeeAnimalId: Int,

    // Spalteninformationen für das Datum, an dem das Like gegeben wurde
    @ColumnInfo(name = "date")
    val date: Date
)
