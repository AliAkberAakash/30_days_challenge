package com.aliakberaakash.thirtydayschallenge.data

import android.app.Application
import com.aliakberaakash.thirtydayschallenge.core.data.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.model.Activity
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.ui.details.DetailsViewModelCallBack
import kotlin.concurrent.thread

class DetailsRepository(val context: Application, private val callBack : DetailsViewModelCallBack) {

    private val db = AppDatabase.getInstance(context)

    fun getChallengeAndActivity(challengeId : Int)
    {
        thread(true) {
            val data = db.challengeDao.getChallengeAndActivity(challengeId)
            callBack.onChallengeAndActivityReceived(data)
        }
    }

    fun insertNewActivity(activity : Activity)
    {
        thread(true) {
            db.activityDao.insert(activity)
            callBack.onInsertChallenge()
        }
    }

    fun updateChallenge(challenge : Challenge)
    {
        thread(true)
        {
            db.challengeDao.update(challenge)
            callBack.onUpdateChallenge()
        }
    }
}