package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import androidx.room.ColumnInfo

// Definiert eine Datenbank-Entität mit dem Namen "user_profiles"
@Entity(tableName = "user_profiles")
data class UserProfile(
    // Definiert den Primärschlüssel der Entität
    @PrimaryKey
    @ColumnInfo(name = "userProfileId") // Legt den Namen der Spalte in der Datenbank fest
    val userProfileId: Int,

    // Spalteninformationen für den Vornamen
    @ColumnInfo(name = "firstName")
    val firstName: String,

    // Spalteninformationen für den Nachnamen
    @ColumnInfo(name = "lastName")
    val lastName: String,

    // Spalteninformationen für das Geburtsdatum
    @ColumnInfo(name = "birthDate")
    val birthDate: Date,

    // Spalteninformationen für die E-Mail-Adresse
    @ColumnInfo(name = "email")
    val email: String,

    // Spalteninformationen für das Passwort
    @ColumnInfo(name = "password")
    val password: String,

    // Spalteninformationen für den Premium-Status
    @ColumnInfo(name = "isPremium")
    val isPremium: Boolean,

    // Spalteninformationen für die verbleibenden Swipes
    @ColumnInfo(name = "swipesLeft")
    val swipesLeft: Int,

    // Spalteninformationen für die Adresse
    @ColumnInfo(name = "address")
    val address: String
)
