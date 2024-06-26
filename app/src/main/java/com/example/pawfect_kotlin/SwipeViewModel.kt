package com.example.pawfect_kotlin

import androidx.lifecycle.ViewModel
import com.example.pawfect_kotlin.data.SwipeUiState
import com.example.pawfect_kotlin.database.PawfectDatabaseTest
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Gender
import com.example.pawfect_kotlin.database.entity.Intent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SwipeViewModel: ViewModel() {

    /**
     * Cupcake state for this order
     */
    private val _uiState = MutableStateFlow(SwipeUiState(animalProfiles = getAnimalMockProfiles()))
    val uiState: StateFlow<SwipeUiState> = _uiState.asStateFlow()

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
}
