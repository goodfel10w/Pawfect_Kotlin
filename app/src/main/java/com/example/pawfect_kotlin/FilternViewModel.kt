package com.example.pawfect_kotlin

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class FilterUIState(
    val distance: String = "",
    val intention: String = "",
    val animalType: String = "",
    val age: String = "",
    val size: String = ""
)

class FilterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FilterUIState())
    val uiState: StateFlow<FilterUIState> = _uiState

    fun updateFilter(option: String, value: String) {
        viewModelScope.launch {
            _uiState.value = when (option) {
                "distance" -> _uiState.value.copy(distance = value)
                "intention" -> _uiState.value.copy(intention = value)
                "animalType" -> _uiState.value.copy(animalType = value)
                "age" -> _uiState.value.copy(age = value)
                "size" -> _uiState.value.copy(size = value)
                else -> _uiState.value
            }
        }
    }
}

