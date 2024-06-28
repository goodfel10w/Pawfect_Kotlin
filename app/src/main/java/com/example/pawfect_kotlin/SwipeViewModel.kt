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
        _uiState.value = _uiState.value.copy(indexOfList = _uiState.value.indexOfList.inc())
        Log.v(TAG, "Like Added for " + _uiState.value.animalProfiles[_uiState.value.indexOfList].animalProfileId + "index = " + _uiState.value.indexOfList)
    }

    fun addDislike() {
        _uiState.value = _uiState.value.copy(indexOfList = _uiState.value.indexOfList.inc())
        Log.v(TAG, "Disliked Added for " + _uiState.value.animalProfiles[_uiState.value.indexOfList].animalProfileId + "index = " + _uiState.value.indexOfList)
    }

    private fun checkForEndOfProfiles() {
        if (_uiState.value.animalProfiles.size == _uiState.value.indexOfList) {
            //List End reached
            _uiState.value = _uiState.value.copy(noMoreProfilesLoaded = true)
        }
    }

    private fun getAnimalMockProfiles(): List<AnimalProfile> {
        val animal1 = AnimalProfile(
            animalProfileId = 1,
            userProfileId = 101,
            name = "Buddy",
            age = 3,
            gender = Gender.MALE,
            images = "url_to_image_1",
            species = "Hund",
            breed = "Golden Retriever",
            characteristics = "Freundlich, Energetisch",
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
            species = "Katze",
            breed = "Siam",
            characteristics = "Neugierig, Verspielt",
            size = 30.0,
            weight = 5.0,
            intent = Intent.PLAY,
            description = "Whiskers ist eine neugierige und verspielte Siamkatze, die es liebt zu erkunden und zu kuscheln."
        )

        val animal3 = AnimalProfile(
            animalProfileId = 3,
            userProfileId = 103,
            name = "Bella",
            age = 4,
            gender = Gender.FEMALE,
            images = "url_to_image_3",
            species = "Hund",
            breed = "Labrador",
            characteristics = "Liebenswert, Aktiv",
            size = 55.0,
            weight = 25.0,
            intent = Intent.MATE,
            description = "Bella ist eine liebenswerte und aktive Labradorhündin, die gerne spielt und spazieren geht."
        )

        val animal4 = AnimalProfile(
            animalProfileId = 4,
            userProfileId = 104,
            name = "Simba",
            age = 3,
            gender = Gender.MALE,
            images = "url_to_image_4",
            species = "Katze",
            breed = "Maine Coon",
            characteristics = "Unabhängig, Sanft",
            size = 40.0,
            weight = 6.5,
            intent = Intent.MATE,
            description = "Simba ist eine unabhängige und sanfte Maine Coon, die es liebt, ihre Umgebung zu erkunden."
        )

        val animal5 = AnimalProfile(
            animalProfileId = 5,
            userProfileId = 105,
            name = "Max",
            age = 2,
            gender = Gender.MALE,
            images = "url_to_image_5",
            species = "Hund",
            breed = "Beagle",
            characteristics = "Lebhaft, Neugierig",
            size = 40.0,
            weight = 20.0,
            intent = Intent.PLAY,
            description = "Max ist ein lebhafter und neugieriger Beagle, der gerne draußen ist und neue Dinge entdeckt."
        )

        return listOf(animal1, animal2, animal3, animal4, animal5)
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
                address = "Kaiserstrasse 125, 76131 Karlsruhe"
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
                address = "Kaiserstrasse 125, 76131 Karlsruhe"
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
                address = "Kaiserstrasse 125, 76131 Karlsruhe"
            ),
            UserProfile(
                userProfileId = 4,
                firstName = "Bob",
                lastName = "Brown",
                birthDate = Date(1988, 3, 22),
                email = "bob.brown@example.com",
                password = "password456",
                isPremium = false,
                swipesLeft = 20,
                address = "Kaiserstrasse 125, 76131 Karlsruhe"
            ),
            UserProfile(
                userProfileId = 5,
                firstName = "Carol",
                lastName = "White",
                birthDate = Date(1995, 11, 19),
                email = "carol.white@example.com",
                password = "securepassword789",
                isPremium = true,
                swipesLeft = 8,
                address = "Kaiserstrasse 125, 76131 Karlsruhe"
            )
        )
    }
}
