package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy
import com.example.pawfect_kotlin.database.entity.UserProfile

@Dao
interface UserProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userProfile: UserProfile)

    @Update
    suspend fun update(userProfile: UserProfile)

    @Delete
    suspend fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM user_profiles WHERE userProfileId = :id")
    suspend fun getUserProfileById(id: Int): UserProfile?

    @Query("SELECT * FROM user_profiles")
    suspend fun getAllUserProfiles(): List<UserProfile>
}
