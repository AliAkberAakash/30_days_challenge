package com.aliakberaakash.thirtydayschallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Activity")
data class Activity (

    @PrimaryKey(autoGenerate = true)
    var activityId : Int? = 0,
    @ColumnInfo(name = "challengeId")
    var challengeId : Int = 0,
    @ColumnInfo(name = "date")
    var date : String = ""

    )