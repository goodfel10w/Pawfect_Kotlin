package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.UserProfile

// Definiert ein Data Access Object (DAO) für das Entity UserProfile
@Dao
interface UserProfileDao {

    // Fügt ein neues UserProfile zur Datenbank hinzu oder ersetzt es, falls bereits vorhanden
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userProfile: UserProfile)

    // Ruft alle UserProfile aus der Datenbank ab
    @Query("SELECT * FROM user_profiles")
    suspend fun getAllUserProfiles(): List<UserProfile>
}
