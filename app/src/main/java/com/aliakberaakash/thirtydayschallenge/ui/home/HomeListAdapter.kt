package com.aliakberaakash.thirtydayschallenge.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge

class HomeListAdapter : ListAdapter<Challenge, HomeListViewHolder>(HomeDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}