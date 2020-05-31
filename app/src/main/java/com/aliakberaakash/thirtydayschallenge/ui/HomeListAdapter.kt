package com.aliakberaakash.thirtydayschallenge.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.ui.home.HomeDiffCallBack
import com.aliakberaakash.thirtydayschallenge.ui.home.HomeListViewHolder

class HomeListAdapter : ListAdapter<Challenge, HomeListViewHolder>(HomeDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}