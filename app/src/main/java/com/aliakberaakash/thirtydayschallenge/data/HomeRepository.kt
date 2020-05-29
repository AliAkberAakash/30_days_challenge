package com.aliakberaakash.thirtydayschallenge.data

import android.content.Context
import com.aliakberaakash.thirtydayschallenge.core.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.HomeViewModelCallBack

class HomeRepository(private val context: Context, private val callBack: HomeViewModelCallBack) {
    private var db: AppDatabase = AppDatabase.getInstance(context)

    fun insertChallenge(challenge: Challenge)
    {
        Thread{
            db.challengeDao.insert(challenge)
        }
    }

    fun getChallenge(id : Int)
    {
        Thread{
            //challenge might be null if doesn't exist
            val challenge : Challenge? = db.challengeDao.getChallenge(id)
            callBack.onReceiveChallenge(challenge)
        }
    }
    fun getAllChallenges()
    {
        Thread{
            val challengeList = db.challengeDao.getAllChallenge()
            callBack.onReceivedAllChallenge(challengeList)
        }
    }

    fun deleteChallenge(id: Int)
    {
        Thread{
            db.challengeDao.deleteChallenge(id)
        }
    }

    fun getChallengeAndActivity(id : Int)
    {
        Thread{
            val challengeAndActivity = db.challengeDao.getChallengeAndActivity(id)
            callBack.onReceivedChallengeAndActivity(challengeAndActivity)
        }
    }

    fun getAllChallengeAndActivity()
    {
        Thread{
            val challengeAndActivities = db.challengeDao.getAllChallengeAndActivity()
            callBack.onReceivedAllChallengeAndActivity(challengeAndActivities)
        }
    }


}