package com.example.pawfect_kotlin.data

import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Filter
import com.example.pawfect_kotlin.database.entity.UserProfile
import com.example.pawfect_kotlin.database.entity.getStandardFilter


/*
    val animalProfiles: List<AnimalProfile> -> Liste der Tiere die im UI geladen wird und bewertet werden kann
    val indexOfList: Int = 0 -> Variable um Index der Liste zu speichern
    val currentFilter: Filter = getStandardFilter() -> Filterwert für Standardfilter
    val userProfiles: List<UserProfile>, -> Liste passender Profile zu den Tieren
    val noMoreProfilesLoaded: Boolean = false, -> Wert der angibt das das Listenende erreicht ist
    val matchExists: Boolean = false, -> Wert der angibt das es ein Match gibt

 */
data class SwipeUiState(
    val animalProfiles: List<AnimalProfile>,
    val indexOfList: Int = 0,
    val currentFilter: Filter = getStandardFilter(),
    val userProfiles: List<UserProfile>,
    val noMoreProfilesLoaded: Boolean = false,
    val matchExists: Boolean = false,
)
