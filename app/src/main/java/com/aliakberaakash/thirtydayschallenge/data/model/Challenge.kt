package com.aliakberaakash.thirtydayschallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Challenge")
data class Challenge (

    @PrimaryKey(autoGenerate = true)
    val challengeId : Int = 0,
    @ColumnInfo(name = "title")
    val title : String = "",
    @ColumnInfo(name = "days")
    val days : Int = 0
)