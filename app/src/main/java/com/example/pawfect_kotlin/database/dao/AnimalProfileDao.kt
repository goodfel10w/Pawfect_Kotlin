package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.AnimalProfile

@Dao
interface AnimalProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animalProfile: Any)

    @Query("SELECT * FROM animal_profiles")
    suspend fun getAllAnimalProfiles(): List<AnimalProfile>

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

