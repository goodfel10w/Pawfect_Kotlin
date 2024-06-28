package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Dislike

// Definiert ein Data Access Object (DAO) für das Entity Dislike
@Dao
interface DislikeDao {

    // Fügt ein neues Dislike zur Datenbank hinzu oder ersetzt es, falls bereits vorhanden
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dislike: Dislike)

    // Ruft ein Dislike aus der Datenbank basierend auf der dislikeId ab
    @Query("SELECT * FROM dislikes WHERE dislikeId = :id")
    suspend fun getDislikeById(id: Int): Dislike?

    // Ruft alle Dislikes aus der Datenbank ab
    @Query("SELECT * FROM dislikes")
    suspend fun getAllDislikes(): List<Dislike>
}
