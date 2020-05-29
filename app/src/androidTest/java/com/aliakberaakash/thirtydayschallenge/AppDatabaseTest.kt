package com.aliakberaakash.thirtydayschallenge

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.aliakberaakash.thirtydayschallenge.core.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.localdb.ChallengeAndActivityDao
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var challengeAndActivityDao: ChallengeAndActivityDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        challengeAndActivityDao = db.challengeAndActivityDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}