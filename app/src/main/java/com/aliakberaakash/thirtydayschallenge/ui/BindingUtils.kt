package com.aliakberaakash.thirtydayschallenge.ui

import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import com.aliakberaakash.thirtydayschallenge.utils.convertDaysToPercent
import com.aliakberaakash.thirtydayschallenge.utils.convertDaysToProgress

@BindingAdapter("progressPercentFormatted")
fun TextView.setProgressPercentFormatted(item: Challenge) {
    text = convertDaysToPercent(item.days)
}

@BindingAdapter("progressBarUpdate")
fun ProgressBar.setSleepQualityString(days : Int) {
    progress = convertDaysToProgress(days)
}