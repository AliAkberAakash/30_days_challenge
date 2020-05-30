package com.aliakberaakash.thirtydayschallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.databinding.HomeFragmentBinding
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*


class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(), BottomSheetCallBack{

    private lateinit var bottomSheetDialog : BottomSheetDialog

    override fun getLayoutId() = R.layout.home_fragment

    override fun setVariables(binding: HomeFragmentBinding) {
        binding.viewModel = viewModel

        binding.root.add_new_challenge.setOnClickListener {
            bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.show(requireActivity().supportFragmentManager, "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllChallenge()

        viewModel.challengeList.observe(viewLifecycleOwner, Observer {
            Logger.d(it.toString())
            Log.d("hello", it.size.toString())
        })
    }

    override fun onSavedButtonClicked(title: String) {
        viewModel.insertChallenge(Challenge(null,title, 0))
        bottomSheetDialog.dismiss()
    }


}
