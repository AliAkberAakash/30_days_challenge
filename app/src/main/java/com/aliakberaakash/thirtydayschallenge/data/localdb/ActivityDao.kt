package com.aliakberaakash.thirtydayschallenge.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aliakberaakash.thirtydayschallenge.data.model.Activity

@Dao
interface ActivityDao {

    @Insert
    fun insert(activity: Activity)

    @Query("SELECT * FROM Activity")
    fun getAllActivity() : List<Activity>

    @Query("SELECT * FROM Activity WHERE activityId=:id")
    fun getActivity(id : Int) : Activity

    @Query("DELETE FROM Activity WHERE activityId=:id")
    fun deleteActivity(id : Int)

}