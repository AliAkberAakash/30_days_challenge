package com.aliakberaakash.thirtydayschallenge.data.localdb

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity

@Dao
interface ChallengeAndActivityDao {

    //get all challenges and all associated activities
    @Transaction
    @Query("SELECT * FROM Challenge")
    fun getAll(): List<ChallengeAndActivity>

    //get a challenge by id and its associated activities
    @Transaction
    @Query("SELECT * FROM Challenge WHERE challengeId=:id")
    fun getChallenge(id : Int) : ChallengeAndActivity

    //delete challenge by id and its associated activities
    @Transaction
    @Query("DELETE FROM Challenge WHERE challengeId=:id")
    fun deleteChallenge(id : Int)


}