package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Match

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match: Match)

    @Update
    suspend fun update(match: Match)

    @Delete
    suspend fun delete(match: Match)

    @Query("SELECT * FROM matches WHERE matchId = :id")
    suspend fun getMatchById(id: Int): Match?

    @Query("SELECT * FROM matches")
    suspend fun getAllMatches(): List<Match>
}
