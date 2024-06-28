package com.example.pawfect_kotlin.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

// Definiert eine Datenbank-Entität mit dem Namen "animal_profiles"
@Entity(tableName = "animal_profiles")
data class AnimalProfile(
    // Definiert den Primärschlüssel der Entität
    @PrimaryKey
    @ColumnInfo(name = "animalProfileId") // Legt den Namen der Spalte in der Datenbank fest
    val animalProfileId: Int,

    // Spalteninformationen für die ID des zugehörigen Benutzerprofils
    @ColumnInfo(name = "userProfileId")
    val userProfileId: Int,

    // Spalteninformationen für den Namen des Tiers
    @ColumnInfo(name = "name")
    val name: String,

    // Spalteninformationen für das Alter des Tiers
    @ColumnInfo(name = "age")
    val age: Int,

    // Spalteninformationen für das Geschlecht des Tiers
    @ColumnInfo(name = "gender")
    val gender: Gender,

    // Spalteninformationen für die Bild-URL des Tiers
    @ColumnInfo(name = "images")
    val images: String,

    // Spalteninformationen für die Spezies des Tiers
    @ColumnInfo(name = "species")
    val species: String,

    // Spalteninformationen für die Rasse des Tiers
    @ColumnInfo(name = "breed")
    val breed: String,

    // Spalteninformationen für die Charakteristika des Tiers
    @ColumnInfo(name = "characteristics")
    val characteristics: String,

    // Spalteninformationen für die Größe des Tiers
    @ColumnInfo(name = "size")
    val size: Double,

    // Spalteninformationen für das Gewicht des Tiers
    @ColumnInfo(name = "weight")
    val weight: Double,

    // Spalteninformationen für die Absicht des Tiers (z.B. Spielen, Paaren)
    @ColumnInfo(name = "intent")
    val intent: Intent,

    // Spalteninformationen für die Beschreibung des Tiers
    @ColumnInfo(name = "description")
    val description: String,

    // Spalteninformationen für die Entfernung des Tiers
    @ColumnInfo(name = "distance")
    val distance: Float
)
