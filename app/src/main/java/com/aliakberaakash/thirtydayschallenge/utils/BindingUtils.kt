package com.aliakberaakash.thirtydayschallenge.utils

import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.aliakberaakash.thirtydayschallenge.R
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge

@BindingAdapter("progressPercentFormatted")
fun TextView.setProgressPercentFormatted(item: Challenge) {
    text = convertDaysToPercent(item.days)
    Log.d("utils", convertDaysToPercent(item.days))
}

@BindingAdapter("progressBarUpdate")
fun ProgressBar.setSleepQualityString(item: Challenge?) {
    progress = if(item != null)
        convertDaysToProgress(item.days)
    else
        convertDaysToProgress(0)
}

@BindingAdapter("setSource")
fun ImageView.setSource(item : Challenge?)
{
    if(item != null)
    {
        if(item.days == 30)
            setImageResource(R.drawable.completed)
        else
            setImageResource(R.drawable.not_done)
    }
}