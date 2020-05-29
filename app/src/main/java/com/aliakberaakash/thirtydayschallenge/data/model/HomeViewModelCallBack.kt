package com.aliakberaakash.thirtydayschallenge.data.model

interface HomeViewModelCallBack {

    fun onReceiveChallenge(challenge: Challenge?)
    fun onReceivedAllChallenge(challengeList : List<Challenge>)
    fun onReceivedChallengeAndActivity(challengeAndActivity: ChallengeAndActivity)
    fun onReceivedAllChallengeAndActivity(challengeAndActivities: List<ChallengeAndActivity>)

}