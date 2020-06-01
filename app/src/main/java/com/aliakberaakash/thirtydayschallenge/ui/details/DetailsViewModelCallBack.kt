package com.aliakberaakash.thirtydayschallenge.ui.details

import com.aliakberaakash.thirtydayschallenge.data.model.ChallengeAndActivity

interface DetailsViewModelCallBack {

    fun onChallengeAndActivityReceived(challengeAndActivity: ChallengeAndActivity)
    fun onUpdateChallenge()

}