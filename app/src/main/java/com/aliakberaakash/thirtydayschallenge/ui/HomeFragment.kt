package com.aliakberaakash.thirtydayschallenge.ui

import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

    override fun getLayoutId() = R.layout.home_fragment

    override fun setVariables(binding: HomeFragmentBinding) {
        binding.viewModel = viewModel
    }

}
