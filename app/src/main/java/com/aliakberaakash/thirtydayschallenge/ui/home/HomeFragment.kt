package com.aliakberaakash.thirtydayschallenge.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.core.ui.BaseFragment
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.databinding.HomeFragmentBinding
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.home_fragment.view.*


class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(),
    BottomSheetCallBack {

    private lateinit var bottomSheetDialog : BottomSheetDialog
    private lateinit var adapter : HomeListAdapter

    override fun getLayoutId() = R.layout.home_fragment

    override fun setVariables(binding: HomeFragmentBinding) {
        binding.viewModel = viewModel

        binding.root.add_new_challenge.setOnClickListener {
            bottomSheetDialog =
                BottomSheetDialog(
                    this
                )
            bottomSheetDialog.show(requireActivity().supportFragmentManager, "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllChallenge()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter =
            HomeListAdapter()
        binding.recyclerView.adapter = adapter

        //binding.imageView.visibility = View.INVISIBLE

        viewModel.challengeList.observe(viewLifecycleOwner, Observer {
            Logger.d(it.toString())
            Log.d("hello", it.size.toString())

            adapter.submitList(it)
        })
    }

    override fun onSavedButtonClicked(title: String) {
        if(title.trim().isNotEmpty())
            viewModel.insertChallenge(Challenge(null, title, 0))
        else
            makeShortToast("Title can not be empty")



        bottomSheetDialog.dismiss()
    }


}
