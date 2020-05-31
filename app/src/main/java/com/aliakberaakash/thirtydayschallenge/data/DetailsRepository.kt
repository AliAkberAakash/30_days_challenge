package com.aliakberaakash.thirtydayschallenge.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliakberaakash.thirtydayschallenge.core.data.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity
import com.aliakberaakash.thirtydayschallenge.ui.details.DetailsViewModelCallBack
import kotlin.concurrent.thread

class DetailsRepository(val context: Application, val callBack : DetailsViewModelCallBack) {

    private val _challengeAndActivity : MutableLiveData<ChallengeAndActivity> = MutableLiveData()
    val challengeAndActivity : LiveData<ChallengeAndActivity>
    get() = _challengeAndActivity

    private val db = AppDatabase.getInstance(context)

    fun getChallengeAndActivity(challengeId : Int)
    {
        thread(true) {
            val data = db.challengeDao.getChallengeAndActivity(challengeId)
            _challengeAndActivity.postValue(data)
        }
    }
}