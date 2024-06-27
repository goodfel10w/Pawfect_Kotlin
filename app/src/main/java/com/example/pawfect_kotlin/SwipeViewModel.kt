package com.example.pawfect_kotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pawfect_kotlin.data.SwipeUiState
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Gender
import com.example.pawfect_kotlin.database.entity.Intent
import com.example.pawfect_kotlin.database.entity.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.sql.Date

const val TAG = "SwipeActivity"

class SwipeViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(SwipeUiState(animalProfiles = getAnimalMockProfiles(), userProfiles = mockUserProfiles() ))
    val uiState: StateFlow<SwipeUiState> = _uiState.asStateFlow()

    fun addLike() {
        uiState.value.indexOfList.inc()
        Log.v(TAG, "Like Added for " + _uiState.value.animalProfiles[_uiState.value.indexOfList].animalProfileId)
    }

    fun addDislike() {
        uiState.value.indexOfList.inc()
        Log.v(TAG, "Disliked Added for " + _uiState.value.animalProfiles[_uiState.value.indexOfList].animalProfileId)
    }

    private fun getAnimalMockProfiles(): List<AnimalProfile> {
        val animal1 = AnimalProfile(
            animalProfileId = 1,
            userProfileId = 101,
            name = "Buddy",
            age = 3,
            gender = Gender.MALE,
            images = "url_to_image_1",
            species = "Dog",
            breed = "Golden Retriever",
            characteristics = "Friendly, Energetic",
            size = 60.0,
            weight = 30.0,
            intent = Intent.MATE,
            description = "Buddy is a friendly and energetic Golden Retriever looking for a loving home."
        )

        val animal2 = AnimalProfile(
            animalProfileId = 2,
            userProfileId = 102,
            name = "Whiskers",
            age = 2,
            gender = Gender.FEMALE,
            images = "url_to_image_2",
            species = "Cat",
            breed = "Siamese",
            characteristics = "Curious, Playful",
            size = 30.0,
            weight = 5.0,
            intent = Intent.PLAY,
            description = "Whiskers is a curious and playful Siamese cat who loves to explore and cuddle."
        )

        val animal3 = AnimalProfile(
            animalProfileId = 3,
            userProfileId = 103,
            name = "Charlie",
            age = 1,
            gender = Gender.MALE,
            images = "url_to_image_3",
            species = "Rabbit",
            breed = "Lop",
            characteristics = "Calm, Gentle",
            size = 25.0,
            weight = 2.5,
            intent = Intent.PLAY,
            description = "Charlie is a calm and gentle Lop rabbit who enjoys a quiet and cozy environment."
        )

        return listOf(animal1, animal2, animal3)
    }

    fun mockUserProfiles(): List<UserProfile> {
        return listOf(
            UserProfile(
                userProfileId = 1,
                firstName = "John",
                lastName = "Doe",
                birthDate = Date(1990, 5, 15),
                email = "john.doe@example.com",
                password = "password123",
                isPremium = true,
                swipesLeft = 10,
                address = "123 Main St, Springfield, USA"
            ),
            UserProfile(
                userProfileId = 2,
                firstName = "Jane",
                lastName = "Smith",
                birthDate = Date(1985, 8, 25),
                email = "jane.smith@example.com",
                password = "securepassword",
                isPremium = false,
                swipesLeft = 15,
                address = "456 Elm St, Metropolis, USA"
            ),
            UserProfile(
                userProfileId = 3,
                firstName = "Alice",
                lastName = "Johnson",
                birthDate = Date(1992, 12, 5),
                email = "alice.johnson@example.com",
                password = "mypassword",
                isPremium = true,
                swipesLeft = 5,
                address = "789 Oak St, Gotham, USA"
            )
        )
    }
}
