package com.aliakberaakash.thirtydayschallenge.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ChallengeAndActivity (

    @Embedded var challenge: Challenge,
    @Relation(
        parentColumn = "challengeId",
        entityColumn = "challengeId"
    )
    var activityList: List<Activity>
)