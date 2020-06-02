package com.aliakberaakash.thirtydayschallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.databinding.HomeListItemBinding
import com.bumptech.glide.Glide

class HomeListViewHolder(private val binding : HomeListItemBinding) : RecyclerView.ViewHolder(binding.root){

    companion object {
        fun from(parent: ViewGroup): HomeListViewHolder {

            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HomeListItemBinding.inflate(
                layoutInflater, parent, false)

            return HomeListViewHolder(
                binding
            )
        }
    }

    fun bind(item: Challenge) {

        binding.days.text = item.days.toString()

        binding.challenge = item
        binding.executePendingBindings()

        binding.parentLayout.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item.challengeId!!)
            binding.parentLayout.findNavController().navigate(action)
        }

    }

}