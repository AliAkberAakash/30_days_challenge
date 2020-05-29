package com.aliakberaakash.thirtydayschallenge.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aliakberaakash.thirtydayschallenge.data.localdb.ChallengeDao
import com.aliakberaakash.thirtydayschallenge.data.model.Activity
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge

@Database(entities = [Challenge::class, Activity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val challengeDao: ChallengeDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "challenge_activities_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}