package com.example.pawfect_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pawfect_kotlin.data.FilterUiState
import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilterViewModel(private val animalProfileDao: AnimalProfileDao) : ViewModel() {

    private val _uiState = MutableStateFlow(FilterUiState())
    val uiState: StateFlow<FilterUiState> = _uiState

    fun updateDistance(value: Float) {
        _uiState.value = _uiState.value.copy(distance = value)
    }

    fun updateZuchtpartner(value: Boolean) {
        _uiState.value = _uiState.value.copy(zuchtpartner = value)
    }

    fun updateSpielpartner(value: Boolean) {
        _uiState.value = _uiState.value.copy(spielpartner = value)
    }

    fun updateHund(value: Boolean) {
        _uiState.value = _uiState.value.copy(hund = value)
    }

    fun updateKatze(value: Boolean) {
        _uiState.value = _uiState.value.copy(katze = value)
    }

    fun updateMinAge(value: Float) {
        _uiState.value = _uiState.value.copy(minAge = value)
    }

    fun updateMaxSize(value: Float) {
        _uiState.value = _uiState.value.copy(maxSize = value)
    }

    fun resetFilters() {
        _uiState.value = FilterUiState()
    }

    fun applyFilters() {
        viewModelScope.launch {
            val state = _uiState.value
            val filteredProfiles = animalProfileDao.getFilteredAnimalProfiles(
                state.distance,
                state.zuchtpartner,
                state.spielpartner,
                state.hund,
                state.katze,
                state.minAge,
                state.maxSize
            )
        }
    }
}
