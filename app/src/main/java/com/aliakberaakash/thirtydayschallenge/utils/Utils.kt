package com.aliakberaakash.thirtydayschallenge.utils

fun convertDaysToPercent(days : Int) : String {
    val percent = convertDaysToProgress(days)

    return "$percent%"
}

fun convertDaysToProgress(days : Int) : Int
{
    return (((days*1.0)/30.0)*100).toInt()
}