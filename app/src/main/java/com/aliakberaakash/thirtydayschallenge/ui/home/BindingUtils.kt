package com.aliakberaakash.thirtydayschallenge.ui.home

import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.utils.convertDaysToPercent
import com.aliakberaakash.thirtydayschallenge.utils.convertDaysToProgress

@BindingAdapter("progressPercentFormatted")
fun TextView.setProgressPercentFormatted(item: Challenge) {
    text = convertDaysToPercent(item.days)
    Log.d("utils", convertDaysToPercent(item.days))
}

@BindingAdapter("progressBarUpdate")
fun ProgressBar.setSleepQualityString(item: Challenge) {
    progress = convertDaysToProgress(item.days)
}