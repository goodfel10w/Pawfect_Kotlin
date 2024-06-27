package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.entity.AnimalProfile

@Dao
interface LikeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(like: Like)

    @Update
    suspend fun update(like: Like)

    @Delete
    suspend fun delete(like: Like)

    @Query("SELECT * FROM likes WHERE likeId = :id")
    suspend fun getLikeById(id: Int): Like?

    @Query("SELECT * FROM likes")
    suspend fun getAllLikes(): List<Like>

    @Query("SELECT * FROM likes WHERE likerAnimalId = :animalProfileId")
    suspend fun getAllLikedProfiles(animalProfileId: Int): List<Like>

    //Zur Überprüfung der Existenz eines Likes vom Gegenüber
    @Query("SELECT * FROM likes WHERE likerAnimalId = :likerId AND likeeAnimalId = :likeeId")
    suspend fun getAllPossibleMatchesForLikerId(likerId: Int, likeeId: Int): AnimalProfile?
}
