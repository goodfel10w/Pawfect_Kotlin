package com.example.pawfect_kotlin.data

import com.example.pawfect_kotlin.database.entity.AnimalProfile

data class SwipeUiState(
    val animalProfiles: List<AnimalProfile>,
    val indexOfList: Int = 0,
    val currentFilter: Filter = getStandardFilter()
    val userProfiles: List<UserProfile>
)
