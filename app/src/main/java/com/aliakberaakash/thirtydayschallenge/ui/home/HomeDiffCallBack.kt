package com.aliakberaakash.thirtydayschallenge.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge

class HomeDiffCallBack : DiffUtil.ItemCallback<Challenge>() {
    override fun areItemsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
        return oldItem.challengeId == newItem.challengeId
    }

    override fun areContentsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
        return oldItem == newItem
    }


}