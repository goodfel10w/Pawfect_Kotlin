package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Like

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
}
