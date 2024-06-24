package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Dislike

@Dao
interface DislikeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dislike: Dislike)

    @Update
    suspend fun update(dislike: Dislike)

    @Delete
    suspend fun delete(dislike: Dislike)

    @Query("SELECT * FROM dislikes WHERE dislikeId = :id")
    suspend fun getDislikeById(id: Int): Dislike?

    @Query("SELECT * FROM dislikes")
    suspend fun getAllDislikes(): List<Dislike>
}
