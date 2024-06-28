package com.example.pawfect_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pawfect_kotlin.database.entity.UserProfile
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Dislike
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.entity.Match
import com.example.pawfect_kotlin.database.dao.UserProfileDao
import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import com.example.pawfect_kotlin.database.dao.DislikeDao
import com.example.pawfect_kotlin.database.dao.LikeDao
import com.example.pawfect_kotlin.database.dao.MatchDao

// Annotation zur Definition der Room-Datenbank
@Database(
    entities = [
        UserProfile::class,
        AnimalProfile::class,
        Dislike::class,
        Like::class,
        Match::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PawfectDatabase : RoomDatabase() {

    // Abstrakte Methoden zur Rückgabe der DAO-Instanzen
    abstract fun userProfileDao(): UserProfileDao
    abstract fun animalProfileDao(): AnimalProfileDao
    abstract fun dislikeDao(): DislikeDao
    abstract fun likeDao(): LikeDao
    abstract fun matchDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: PawfectDatabase? = null

        // Methode zur Rückgabe der Datenbankinstanz
        fun getDatabase(context: Context): PawfectDatabase {
            // Doppelt überprüfte Sperre zur Sicherstellung eines Thread-sicheren Zugriffs
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PawfectDatabase::class.java,
                    "pawfect_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}