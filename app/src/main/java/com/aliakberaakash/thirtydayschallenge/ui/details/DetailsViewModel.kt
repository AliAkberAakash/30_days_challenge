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
    var message : MutableLiveData<String> = MutableLiveData("")

    val challenge = Transformations.map(_challengeAndActivity)
    {
        it.challenge
    }

    private val activityList = Transformations.map(_challengeAndActivity)
    {
        Log.d("ActivityList", it.activityList.toString())
        it.activityList
    }

    val visibility = Transformations.map(activityList)
    {
        val date = getCurrentDateTime().toString("dd/MM/yyyy")
        //val date = "03/06/2020"
        var retVal = View.VISIBLE

        message.postValue(myApplication.getString(R.string.done))

        for(x in it)
            if(x.date == date && x.challengeId == challenge.value!!.challengeId) {
                retVal = View.INVISIBLE
                break
            }

        if(retVal == View.VISIBLE)
            message.postValue("")

        if(challenge.value!!.days >= 30)
        {
            retVal = View.INVISIBLE
            message.postValue(myApplication.getString(R.string.done))
        }

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
        //val date = "03/06/2020"
        val myChallenge : Challenge = challenge.value!!
        myChallenge.days++
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
