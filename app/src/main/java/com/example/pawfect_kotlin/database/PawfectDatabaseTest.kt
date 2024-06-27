package com.example.pawfect_kotlin.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pawfect_kotlin.database.entity.UserProfile
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Dislike
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.dao.UserProfileDao
import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import com.example.pawfect_kotlin.database.dao.DislikeDao
import com.example.pawfect_kotlin.database.dao.LikeDao
import com.example.pawfect_kotlin.database.dao.MatchDao
import com.example.pawfect_kotlin.database.entity.Gender
import com.example.pawfect_kotlin.database.entity.Intent
import com.example.pawfect_kotlin.database.entity.Match
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class PawfectDatabaseTest {

    private lateinit var db: PawfectDatabase
    private lateinit var userProfileDao: UserProfileDao
    private lateinit var animalProfileDao: AnimalProfileDao
    private lateinit var likeDao: LikeDao
    private lateinit var dislikeDao: DislikeDao
    private lateinit var matchDao: MatchDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, PawfectDatabase::class.java).build()
        userProfileDao = db.userProfileDao()
        animalProfileDao = db.animalProfileDao()
        likeDao = db.likeDao()
        dislikeDao = db.dislikeDao()
        matchDao = db.matchDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    suspend fun testDatabase() {
        val userProfiles = listOf(
            UserProfile(1, "John", "Doe", Date(), "john@example.com", "password123", false, 5, "123 Street"),
            UserProfile(2, "Jane", "Smith", Date(), "jane@example.com", "password123", true, 3, "456 Avenue"),
            UserProfile(3, "Alice", "Johnson", Date(), "alice@example.com", "password123", false, 10, "789 Boulevard"),
            UserProfile(4, "Bob", "Brown", Date(), "bob@example.com", "password123", true, 7, "101 Road"),
            UserProfile(5, "Charlie", "Davis", Date(), "charlie@example.com", "password123", false, 2, "202 Way")
        )

        userProfiles.forEach { userProfileDao.insert(it) }

        val animalProfiles = listOf(
            AnimalProfile(1, 1, "Buddy", 3, Gender.MALE, "image1.jpg", "Dog", "Labrador", "Friendly", 60.0, 30.0, Intent.PLAY, "Playful and energetic"),
            AnimalProfile(2, 2, "Mittens", 2, Gender.FEMALE, "image2.jpg", "Cat", "Siamese", "Calm", 25.0, 5.0, Intent.MATE, "Quiet and affectionate"),
            AnimalProfile(3, 3, "Max", 5, Gender.MALE, "image3.jpg", "Dog", "Beagle", "Curious", 40.0, 20.0, Intent.PLAY, "Loves to explore"),
            AnimalProfile(4, 4, "Bella", 4, Gender.FEMALE, "image4.jpg", "Cat", "Persian", "Lazy", 30.0, 6.0, Intent.MATE, "Loves to sleep"),
            AnimalProfile(5, 5, "Rocky", 1, Gender.MALE, "image5.jpg", "Dog", "Bulldog", "Strong", 50.0, 25.0, Intent.PLAY, "Very strong and loyal"),
            AnimalProfile(6, 1, "Luna", 3, Gender.FEMALE, "image6.jpg", "Cat", "Bengal", "Playful", 28.0, 7.0, Intent.MATE, "Playful and agile"),
            AnimalProfile(7, 2, "Charlie", 2, Gender.MALE, "image7.jpg", "Dog", "Poodle", "Intelligent", 45.0, 22.0, Intent.PLAY, "Very smart and friendly"),
            AnimalProfile(8, 3, "Lucy", 5, Gender.FEMALE, "image8.jpg", "Cat", "Maine Coon", "Gentle", 35.0, 8.0, Intent.MATE, "Gentle and large"),
            AnimalProfile(9, 4, "Daisy", 4, Gender.FEMALE, "image9.jpg", "Dog", "Golden Retriever", "Friendly", 55.0, 27.0, Intent.PLAY, "Friendly and easygoing"),
            AnimalProfile(10, 5, "Simba", 1, Gender.MALE, "image10.jpg", "Cat", "Sphinx", "Affectionate", 32.0, 6.0, Intent.MATE, "Affectionate and unique")
        )

        animalProfiles.forEach { animalProfileDao.insert(it) }

        val likes = listOf(
            Like(1, 1, 2, Date()), Like(2, 3, 4, Date()), Like(3, 5, 6, Date()),
            Like(4, 7, 8, Date()), Like(5, 9, 10, Date())
        )

        likes.forEach { likeDao.insert(it) }

        val dislikes = listOf(
            Dislike(1, 2, 3, Date()), Dislike(2, 4, 5, Date()), Dislike(3, 6, 7, Date()),
            Dislike(4, 8, 9, Date()), Dislike(5, 10, 1, Date())
        )

        dislikes.forEach { dislikeDao.insert(it) }

        val matches = listOf(
            Match(1, 1, 2, Date()), Match(2, 3, 4, Date()), Match(3, 5, 6, Date()),
            Match(4, 7, 8, Date()), Match(5, 9, 10, Date())
        )

        matches.forEach { matchDao.insert(it) }

        // Überprüfen, ob die Einfügungen erfolgreich waren
        val retrievedUserProfiles = userProfileDao.getAllUserProfiles()
        assertEquals(userProfiles.size, retrievedUserProfiles.size)

        val retrievedAnimalProfiles = animalProfileDao.getAllAnimalProfiles()
        assertEquals(animalProfiles.size, retrievedAnimalProfiles.size)

        val retrievedLikes = likeDao.getAllLikes()
        assertEquals(likes.size, retrievedLikes.size)

        val retrievedDislikes = dislikeDao.getAllDislikes()
        assertEquals(dislikes.size, retrievedDislikes.size)

        val retrievedMatches = matchDao.getAllMatches()
        assertEquals(matches.size, retrievedMatches.size)

        // Weitere Assertions zum Überprüfen der Integrität der Daten
        val retrievedLike = likeDao.getLikeById(1)
        assertNotNull(retrievedLike)
        assertEquals(1, retrievedLike?.likeId)
        assertEquals(1, retrievedLike?.likerAnimalId)
        assertEquals(2, retrievedLike?.likeeAnimalId)

        val retrievedDislike = dislikeDao.getDislikeById(1)
        assertNotNull(retrievedDislike)
        assertEquals(1, retrievedDislike?.dislikeId)
        assertEquals(2, retrievedDislike?.dislikerAnimalId)
        assertEquals(3, retrievedDislike?.dislikeeAnimalId)

        val retrievedMatch = matchDao.getMatchById(1)
        assertNotNull(retrievedMatch)
        assertEquals(1, retrievedMatch?.matchId)
        assertEquals(1, retrievedMatch?.animal1Id)
        assertEquals(2, retrievedMatch?.animal2Id)
    }
}
