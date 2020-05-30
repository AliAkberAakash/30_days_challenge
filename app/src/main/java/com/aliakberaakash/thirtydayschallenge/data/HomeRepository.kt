package com.aliakberaakash.thirtydayschallenge.data

import android.content.Context
import com.aliakberaakash.thirtydayschallenge.core.data.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.model.Activity
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.HomeViewModelCallBack
import kotlin.concurrent.thread

class HomeRepository(private val context: Context, private val callBack: HomeViewModelCallBack) {
    private var db: AppDatabase = AppDatabase.getInstance(context)

    fun insertChallenge(challenge: Challenge)
    {
        thread(true){
            db.challengeDao.insert(challenge)
            callBack.onInsertChallenge()
        }
    }

    fun getChallenge(id : Int)
    {
        thread(true){
            //challenge might be null if doesn't exist
            val challenge : Challenge? = db.challengeDao.getChallenge(id)
            callBack.onReceiveChallenge(challenge)
        }
    }
    fun getAllChallenges()
    {
        thread(true){
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

    fun insertActivity(activity: Activity)
    {
        Thread{
            db.activityDao.insert(activity)
        }
    }

}