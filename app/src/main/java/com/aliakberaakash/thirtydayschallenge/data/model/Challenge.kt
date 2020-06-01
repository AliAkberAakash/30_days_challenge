package com.aliakberaakash.thirtydayschallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Challenge")
data class Challenge (

    @PrimaryKey(autoGenerate = true)
    val challengeId : Int?,
    @ColumnInfo(name = "title")
    val title : String = "",
    @ColumnInfo(name = "days")
    var days : Int = 0
)