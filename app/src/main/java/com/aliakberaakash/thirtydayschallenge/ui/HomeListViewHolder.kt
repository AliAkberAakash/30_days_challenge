package com.aliakberaakash.thirtydayschallenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.databinding.HomeListItemBinding

class HomeListViewHolder(private val binding : HomeListItemBinding) : RecyclerView.ViewHolder(binding.root){

    companion object {
        fun from(parent: ViewGroup): HomeListViewHolder {

            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HomeListItemBinding.inflate(
                layoutInflater, parent, false)

            return HomeListViewHolder(binding)
        }
    }

    fun bind(item: Challenge) {

        val myContext = itemView.context

    }

}