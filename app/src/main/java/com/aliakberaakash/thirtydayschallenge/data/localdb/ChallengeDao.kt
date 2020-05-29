package com.aliakberaakash.thirtydayschallenge.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity

@Dao
interface ChallengeDao {

    @Insert
    fun insert(challenge: Challenge)

    @Query("SELECT * FROM Challenge")
    fun getAllChallenge() : List<Challenge>

    @Query("SELECT * FROM Challenge WHERE challengeId=:id")
    fun getChallenge(id : Int) : Challenge

    @Query("DELETE  FROM Challenge WHERE challengeId=:id")
    fun deleteChallenge(id : Int)

    @Transaction
    @Query("SELECT * FROM Challenge")
    fun getAllChallengeAndActivity(): List<ChallengeAndActivity>

    @Transaction
    @Query("SELECT * FROM Challenge WHERE challengeId=:id")
    fun getChallengeAndActivity(id : Int) : ChallengeAndActivity
}