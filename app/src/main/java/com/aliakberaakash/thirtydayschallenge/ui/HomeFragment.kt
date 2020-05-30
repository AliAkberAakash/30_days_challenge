package com.aliakberaakash.thirtydayschallenge.ui

import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

    override fun getLayoutId() = R.layout.home_fragment

    override fun setVariables(binding: HomeFragmentBinding) {
        binding.viewModel = viewModel

        binding.root.add_new_challenge.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog()
            bottomSheetDialog.show(requireActivity().supportFragmentManager, "")
        }
    }


}
