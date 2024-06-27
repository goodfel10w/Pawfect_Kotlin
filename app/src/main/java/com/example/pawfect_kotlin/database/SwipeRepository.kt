/*
package com.example.pawfect_kotlin.database

import com.example.pawfect_kotlin.database.dao.AnimalProfileDao
import com.example.pawfect_kotlin.database.dao.DislikeDao
import com.example.pawfect_kotlin.database.dao.LikeDao
import com.example.pawfect_kotlin.database.dao.MatchDao
import com.example.pawfect_kotlin.database.entity.AnimalProfile
import com.example.pawfect_kotlin.database.entity.Dislike
import com.example.pawfect_kotlin.database.entity.Filter
import com.example.pawfect_kotlin.database.entity.Like
import com.example.pawfect_kotlin.database.functions.listOfAnimalProfiles

class SwipeRepository (
    private val animalProfileDao: AnimalProfileDao,
    private val likeDao: LikeDao,
    private val dislikeDao: DislikeDao,
    private val matchDao: MatchDao
) {
    suspend fun getAllProfiles(): List<AnimalProfile> {
        return this.animalProfileDao.getAllAnimalProfiles()
    }

    suspend fun applyFilter(allProfiles: List<AnimalProfile>, currentFilter: Filter) {
        listOfAnimalProfiles.clear()

        val listWithUnprocessedProfiles: List<AnimalProfile> = getAllUnprocessedProfiles()

        */
/*for (profile in allProfiles) {
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
}*//*


    }

    private suspend fun getAllUnprocessedProfiles(): List<AnimalProfile> {
        val allProfiles = getAllProfiles()
        val dislikedProfiles = getAllDislikedProfiles()
        val likedProfiles = getAllLikedProfiles()

        return allProfiles.filter { profile ->
            !likedProfiles.any { it.likeeAnimalId == profile.animalProfileId } &&
                    !dislikedProfiles.any { it.dislikeeAnimalId == profile.animalProfileId }
        }
    }

    private suspend fun getAllDislikedProfiles(): List<Dislike> {
        return dislikeDao.getAllDislikes()
    }

    private suspend fun getAllLikedProfiles(): List<Like> {
        return likeDao.getAllLikes()
    }
}
*/

