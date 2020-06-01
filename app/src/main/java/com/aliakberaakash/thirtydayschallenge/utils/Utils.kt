package com.aliakberaakash.thirtydayschallenge.utils

import java.text.SimpleDateFormat
import java.util.*

fun convertDaysToPercent(days : Int) : String {
    val percent = convertDaysToProgress(days)

    return "$percent%"
}

fun convertDaysToProgress(days : Int) : Int
{
    return (((days*1.0)/30.0)*100).toInt()
}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}