package com.example.pawfect_kotlin.database.entity

data class Filter(
    var distance: Double? = null,
    var intent: Intent? = null,
    var species: String? = null,
    var breed: String? = null,
    var age: Int? = null,
    var size: Double? = null
)

fun getStandardFilter(): Filter {
    val standardFilter:Filter = Filter(100.0, null, null, null, null, null)
    return standardFilter
}