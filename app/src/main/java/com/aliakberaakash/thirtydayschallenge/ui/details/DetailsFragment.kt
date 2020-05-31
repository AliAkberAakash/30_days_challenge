package com.aliakberaakash.thirtydayschallenge.ui.details

import android.os.Bundle

import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.databinding.DetailsFragmentBinding

class DetailsFragment : BaseFragment<DetailsViewModel, DetailsFragmentBinding>() {

    override fun getLayoutId() : Int = R.layout.details_fragment

    override fun setVariables(binding: DetailsFragmentBinding) {
        binding.viewModel = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
