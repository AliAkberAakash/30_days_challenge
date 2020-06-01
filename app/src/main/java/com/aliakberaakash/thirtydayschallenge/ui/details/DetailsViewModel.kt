package com.aliakberaakash.thirtydayschallenge.ui.details

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseViewModel
import com.aliakberaakash.thirtydayschallenge.data.DetailsRepository
import com.aliakberaakash.thirtydayschallenge.data.model.Activity
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity
import com.aliakberaakash.thirtydayschallenge.utils.getCurrentDateTime
import com.aliakberaakash.thirtydayschallenge.utils.toString

class DetailsViewModel(private val myApplication : Application) : BaseViewModel(myApplication), DetailsViewModelCallBack {

    private val _challengeAndActivity : MutableLiveData<ChallengeAndActivity> = MutableLiveData()
    val challengeAndActivity : LiveData<ChallengeAndActivity>
        get() = _challengeAndActivity

    val challenge = Transformations.map(_challengeAndActivity)
    {
        it.challenge
    }

    private val activityList = Transformations.map(_challengeAndActivity)
    {
        it.activityList
    }

    val visibility = Transformations.map(activityList)
    {
        val date = getCurrentDateTime().toString("dd/MM/yyyy")
        var retVal = View.VISIBLE

        for(x in it)
            if(x.date == date && x.challengeId == challenge.value!!.challengeId)
                retVal = View.INVISIBLE

        if(challenge.value!!.days >= 30)
            retVal = View.INVISIBLE

        retVal
    }

    private val repository = DetailsRepository(myApplication, this)

    fun getChallengeAndActivity(challengeId : Int)
    {
        repository.getChallengeAndActivity(challengeId)
    }

    fun onCheckInClicked()
    {
        val date = getCurrentDateTime().toString("dd/MM/yyyy")
        val myChallenge : Challenge = challenge.value!!
        myChallenge.days = 30
        val activity = Activity(null, myChallenge.challengeId!!, date)
        repository.insertNewActivity(activity)
        repository.updateChallenge(myChallenge)

        Log.d("date", date)
    }

    override fun onChallengeAndActivityReceived(myChallengeAndActivity: ChallengeAndActivity) {
        _challengeAndActivity.postValue(myChallengeAndActivity)
    }

    override fun onUpdateChallenge() {
        getChallengeAndActivity(challenge.value!!.challengeId!!)
    }


}
