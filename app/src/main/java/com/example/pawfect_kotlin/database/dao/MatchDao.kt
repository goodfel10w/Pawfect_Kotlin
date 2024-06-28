package com.example.pawfect_kotlin.database.dao

import androidx.room.*
import com.example.pawfect_kotlin.database.entity.Match

// Definiert ein Data Access Object (DAO) für das Entity Match
@Dao
interface MatchDao {

    // Fügt ein neues Match zur Datenbank hinzu oder ersetzt es, falls bereits vorhanden
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match: Match)

    // Ruft ein Match aus der Datenbank basierend auf der matchId ab
    @Query("SELECT * FROM matches WHERE matchId = :id")
    suspend fun getMatchById(id: Int): Match?

    // Ruft alle Matches aus der Datenbank ab
    @Query("SELECT * FROM matches")
    suspend fun getAllMatches(): List<Match>
}
