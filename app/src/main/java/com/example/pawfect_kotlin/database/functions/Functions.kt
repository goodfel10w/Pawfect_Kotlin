package com.example.pawfect_kotlin.database.functions

import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import androidx.room.*
import com.example.pawfect_kotlin.database.dao.DislikeDao
import com.example.pawfect_kotlin.database.dao.LikeDao
import com.example.pawfect_kotlin.database.dao.MatchDao
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.entity.Dislike
import com.example.pawfect_kotlin.database.entity.Filter
import com.example.pawfect_kotlin.database.entity.getStandardFilter

//Variablen, die beim Starten der App initiiert werden
var listOfAnimalProfiles = mutableListOf<AnimalProfile>()
var animalProfileListIndex: Int = 0
var currentFilter: Filter = getStandardFilter()

//Funktionen, die beim Starten der App ausgelöst wird
//Funktion zur Beschaffung einer Liste aller Tierprofile
fun getAllProfiles(): List<AnimalProfile> {
    val allProfiles = mutableListOf<AnimalProfile>()
    allProfiles.addAll(AnimalProfileDao.getAllAnimalProfiles())
    return allProfiles
}

//Funktion zur Anwendung des Filters und Manipulation der Profilliste
fun applyFilter(allProfiles: List<AnimalProfile>, currentFilter: Filter) {
    listOfAnimalProfiles.clear()

    val listOfLikes = mutableListOf<Like>()
    listOfLikes.addAll(LikeDao.getAllLikes())
    val listOfDislikes = mutableListOf<Dislike>()
    listOfDislikes.addAll(DislikeDao.getAllDislikes())

    for (profile in allProfiles) {
        if ((profile.animalProfileId != myProfile.animalProfileId) &&
            (!listOfLikes.any { like -> like.likerAnimalId == myProfile.animalProfileId && like.likeeAnimalId == profile.animalProfileId }) &&
            (!listOfDislikes.any { dislike -> dislike.dislikerAnimalId == myProfile.animalProfileId && dislike.dislikeeAnimalId == profile.animalProfileId })
            ) {
            if (((currentFilter.intent == null) || (currentFilter.intent == profile.intent)) &&
                ((currentFilter.species == null) || (currentFilter.species ==profile.species)) &&
                ((currentFilter.breed == null) || (currentFilter.breed ==profile.breed)) &&
                ((currentFilter.age == null) || (currentFilter.age ==profile.age)) &&
                ((currentFilter.size == null) || (currentFilter.size ==profile.size))){
                    listOfAnimalProfiles.add(profile)
            }
        }
    }
    listOfAnimalProfiles.shuffle()
}

//Funktion zur Übergabe eines zufälligen Tierprofils aus der gefilterten Liste
fun showNextProfile(): AnimalProfile? {
    if (listOfAnimalProfiles.isEmpty()) return null
    animalProfileListIndex++
    return listOfAnimalProfiles[animalProfileListIndex-1]
}


//Funktionen, die beim Klicken des dazugehörigen Buttons ausgelöst werden
//Links-Swipe-Button
fun onLeftSwipeButtonClick(currentProfile: AnimalProfile) {
    DislikeDao.insert(myProfile, currentProfile, System.currentTimeMillis())
    showNextProfile()
}

//Rechts-Swipe-Button
fun onRightSwipeButtonClick(currentProfile: AnimalProfile) {
    LikeDao.insert(myProfile, currentProfile, System.currentTimeMillis())
    val matchExists = MatchDao.existsLike(currentProfile, myProfile)
    if (matchExists) {
        MatchDao.insert(myProfile, currentProfile, System.currentTimeMillis())
        matchFoundPopUp(currentProfile.name)
    }
    showNextProfile()
}

//Filteroptionen-Button
fun onFilterOptionsButtonClick() {
    showFilterOptionsView()
}

//Filter anwenden-Button
fun onApplyFilterButtonClick(filterView: FilterView) {
    currentFilter = filterView
    applyFilter(getAllProfiles(), currentFilter)
    showNextProfile()
}

//Filter löschen-Button
fun onClearFilterButtonClick() {
    currentFilter = getStandardFilter()
    applyFilter(getAllProfiles(), currentFilter)
    showNextProfile()
}