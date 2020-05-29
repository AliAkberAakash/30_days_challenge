package com.aliakberaakash.thirtydayschallenge.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseViewModel
import com.aliakberaakash.thirtydayschallenge.data.HomeRepository
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity
import com.aliakberaakash.thirtydayschallenge.data.model.HomeViewModelCallBack

class HomeViewModel(myApplication : Application) : BaseViewModel(myApplication), HomeViewModelCallBack {

    private val repository = HomeRepository(myApplication, this)

    private val _challengeList : MutableLiveData<List<Challenge>> = MutableLiveData()
    val challengeList : LiveData<List<Challenge>>
        get() = _challengeList

    override fun onReceiveChallenge(challenge: Challenge?) {
        TODO("Not yet implemented")
    }

    override fun onReceivedAllChallenge(myChallengeList: List<Challenge>) {
        _challengeList.value = myChallengeList
    }

    override fun onReceivedChallengeAndActivity(challengeAndActivity: ChallengeAndActivity) {
        TODO("Not yet implemented")
    }

    override fun onReceivedAllChallengeAndActivity(challengeAndActivities: List<ChallengeAndActivity>) {
        TODO("Not yet implemented")
    }

}
