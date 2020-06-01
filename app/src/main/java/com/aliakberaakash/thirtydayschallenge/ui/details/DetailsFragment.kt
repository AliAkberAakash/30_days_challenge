package com.aliakberaakash.thirtydayschallenge.ui.details

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.navArgs

import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.databinding.DetailsFragmentBinding

class DetailsFragment : BaseFragment<DetailsViewModel, DetailsFragmentBinding>() {

    val args : DetailsFragmentArgs by navArgs()

    override fun getLayoutId() : Int = R.layout.details_fragment

    override fun setVariables(binding: DetailsFragmentBinding) {
        binding.viewModel = viewModel

        binding.backButton.setOnClickListener {
            //todo implement up button
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val challengeId = args.challengeId
        viewModel.getChallengeAndActivity(challengeId)

        Log.d("tag", args.challengeId.toString())

    }

}
