package com.example.pawfect_kotlin.database

import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import com.example.pawfect_kotlin.database.dao.DislikeDao
import com.example.pawfect_kotlin.database.dao.LikeDao
import com.example.pawfect_kotlin.database.dao.MatchDao
import com.example.pawfect_kotlin.database.dao.UserProfileDao
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Dislike
import com.example.pawfect_kotlin.database.entity.Filter
import com.example.pawfect_kotlin.database.entity.Like

class SwipeRepository () {

//    suspend fun getAllProfiles(): List<AnimalProfile> {
//        return this.animalProfileDao.getAllAnimalProfiles()
//    }

//    suspend fun applyFilter(allProfiles: List<AnimalProfile>, currentFilter: Filter) {
//        val listWithUnprocessedProfiles: List<AnimalProfile> = getAllUnprocessedProfiles()

//for (profile in allProfiles) {
//        if ((profile.animalProfileId != profile.animalProfileId) &&
//            (!listOfLikes.any { like -> like.likerAnimalId == profile.animalProfileId && like.likeeAnimalId == profile.animalProfileId }) &&
//            (!listOfDislikes.any { dislike -> dislike.dislikerAnimalId == profile.animalProfileId && dislike.dislikeeAnimalId == profile.animalProfileId })
//        ) {
//            if (((currentFilter.intent == null) || (currentFilter.intent == profile.intent)) &&
//                ((currentFilter.species == null) || (currentFilter.species ==profile.species)) &&
//                ((currentFilter.breed == null) || (currentFilter.breed ==profile.breed)) &&
//                ((currentFilter.age == null) || (currentFilter.age ==profile.age)) &&
//                ((currentFilter.size == null) || (currentFilter.size ==profile.size))){
//                listOfAnimalProfiles.add(profile)
//            }
//        }
//    }
//    listOfAnimalProfiles.shuffle()
//}
}



