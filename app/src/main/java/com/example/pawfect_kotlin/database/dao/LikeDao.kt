package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.entity.AnimalProfile

// Definiert ein Data Access Object (DAO) für das Entity Like
@Dao
interface LikeDao {

    // Fügt ein neues Like zur Datenbank hinzu oder ersetzt es, falls bereits vorhanden
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(like: Like)

    // Ruft ein Like aus der Datenbank basierend auf der likeId ab
    @Query("SELECT * FROM likes WHERE likeId = :id")
    suspend fun getLikeById(id: Int): Like?

    // Ruft alle Likes aus der Datenbank ab
    @Query("SELECT * FROM likes")
    suspend fun getAllLikes(): List<Like>

    // Ruft alle Likes ab, die von einem bestimmten Tierprofil gegeben wurden
    @Query("SELECT * FROM likes WHERE likerAnimalId = :animalProfileId")
    suspend fun getAllLikedProfiles(animalProfileId: Int): List<Like>

    // Überprüft, ob es ein Like vom Gegenüber für ein bestimmtes Tierprofil gibt
    @Query("SELECT * FROM likes WHERE likerAnimalId = :likerId AND likeeAnimalId = :likeeId")
    suspend fun getAllPossibleMatchesForLikerId(likerId: Int, likeeId: Int): AnimalProfile?
}
