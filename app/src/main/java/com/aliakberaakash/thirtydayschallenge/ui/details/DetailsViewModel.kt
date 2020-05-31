package com.aliakberaakash.thirtydayschallenge.ui.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseViewModel
import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity

class DetailsViewModel(private val myApplication : Application) : BaseViewModel(myApplication) {

    private val _challengeAndActivity : MutableLiveData<ChallengeAndActivity> = MutableLiveData()
    val challengeAndActivity : LiveData<ChallengeAndActivity>
        get() = _challengeAndActivity

}
