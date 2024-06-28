package com.example.pawfect_kotlin.data

data class FilterUiState(
    val distance: Float = 0f,
    val zuchtpartner: Boolean = true,
    val spielpartner: Boolean = true,
    val hund: Boolean = true,
    val katze: Boolean = true,
    val minAge: Float = 0f,
    val maxSize: Float = 0f
)