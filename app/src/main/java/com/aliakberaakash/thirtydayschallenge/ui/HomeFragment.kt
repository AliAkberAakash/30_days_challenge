package com.aliakberaakash.thirtydayschallenge.ui

import androidx.lifecycle.Observer
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.databinding.HomeFragmentBinding
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*


class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(), BottomSheetCallBack{

    override fun getLayoutId() = R.layout.home_fragment

    override fun setVariables(binding: HomeFragmentBinding) {
        binding.viewModel = viewModel

        viewModel.getAllChallenge()

        viewModel.challengeList.observe(viewLifecycleOwner, Observer {
            Logger.d(it.toString())
        })

        binding.root.add_new_challenge.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.show(requireActivity().supportFragmentManager, "")
        }
    }

    override fun onSavedButtonClicked(title: String) {
        viewModel.insertChallenge(Challenge(-1,title, 0))
    }


}
