package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.AnimalProfile

// Definiert ein Data Access Object (DAO) für das Entity AnimalProfile
@Dao
interface AnimalProfileDao {

    // Fügt ein neues AnimalProfile zur Datenbank hinzu oder ersetzt es, falls bereits vorhanden
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animalProfile: AnimalProfile)

    // Ruft alle AnimalProfile aus der Datenbank ab
    @Query("SELECT * FROM animal_profiles")
    suspend fun getAllAnimalProfiles(): List<AnimalProfile>

    // Führt eine komplexe Abfrage durch, um AnimalProfile basierend auf verschiedenen Filterkriterien abzurufen
    @Query("SELECT * FROM animal_profiles " +
            "WHERE (:distance = 0.0 OR distance <= :distance) " +
            "AND (:zuchtpartner = 0 OR intent = 'Zuchtpartner') " +
            "AND (:spielpartner = 0 OR intent = 'Spielpartner') " +
            "AND (:hund = 0 OR species = 'Dog') " +
            "AND (:katze = 0 OR species = 'Cat') " +
            "AND (:minAge = 0.0 OR age >= :minAge) " +
            "AND (:maxSize = 0.0 OR size <= :maxSize)")
    suspend fun getFilteredAnimalProfiles(
        distance: Float,
        zuchtpartner: Boolean,
        spielpartner: Boolean,
        hund: Boolean,
        katze: Boolean,
        minAge: Float,
        maxSize: Float
    ): List<AnimalProfile>
}
