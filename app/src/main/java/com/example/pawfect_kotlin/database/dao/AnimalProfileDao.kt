package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.AnimalProfile

@Dao
interface AnimalProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animalProfile: AnimalProfile)

    @Update
    suspend fun update(animalProfile: AnimalProfile)

    @Delete
    suspend fun delete(animalProfile: AnimalProfile)

    @Query("SELECT * FROM animal_profiles WHERE animalProfileId = :id")
    suspend fun getAnimalProfileById(id: Int): AnimalProfile?

    @Query("SELECT * FROM animal_profiles")
    suspend fun getAllAnimalProfiles(): List<AnimalProfile>
}
