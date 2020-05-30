package com.aliakberaakash.thirtydayschallenge.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseViewModel
import com.aliakberaakash.thirtydayschallenge.data.HomeRepository
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity
import com.aliakberaakash.thirtydayschallenge.data.model.HomeViewModelCallBack

class HomeViewModel(private val myApplication : Application) : BaseViewModel(myApplication), HomeViewModelCallBack {

    private val repository = HomeRepository(myApplication, this)

    private val _challengeList : MutableLiveData<List<Challenge>> = MutableLiveData()
    val challengeList : LiveData<List<Challenge>>
        get() = _challengeList

    fun insertChallenge(challenge: Challenge)
    {
        repository.insertChallenge(challenge)
    }

    fun getAllChallenge()
    {
        repository.getAllChallenges()
    }

    override fun onReceiveChallenge(challenge: Challenge?) {
        TODO("Not yet implemented")
    }

    override fun onReceivedAllChallenge(myChallengeList: List<Challenge>) {
        _challengeList.postValue(myChallengeList)
    }

    override fun onReceivedChallengeAndActivity(challengeAndActivity: ChallengeAndActivity) {
        TODO("Not yet implemented")
    }

    override fun onReceivedAllChallengeAndActivity(challengeAndActivities: List<ChallengeAndActivity>) {
        TODO("Not yet implemented")
    }

    override fun onInsertChallenge() {
        getAllChallenge()
    }
}
