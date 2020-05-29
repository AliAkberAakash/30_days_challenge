package com.aliakberaakash.thirtydayschallenge

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.aliakberaakash.thirtydayschallenge.core.AppDatabase
import com.aliakberaakash.thirtydayschallenge.data.localdb.ChallengeDao
import com.aliakberaakash.thirtydayschallenge.data.model.Challenge
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var challengeDao: ChallengeDao
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
        challengeDao = db.challengeDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetChallenge() {
        val challenge = Challenge()
        challengeDao.insert(challenge)
        val returnedChallenge = challengeDao.getChallenge(1)
        assertEquals(returnedChallenge.challengeId, 1)
    }

    @Test
    @Throws(Exception::class)
    fun insertMultipleAndGetAllChallenge() {
        val challenge1 = Challenge()
        val challenge2 = Challenge()

        challengeDao.insert(challenge1)
        challengeDao.insert(challenge2)

        val challengeList = challengeDao.getAllChallenge()
        assertEquals(challengeList.size, 2)
        assertEquals(challengeList[0].challengeId, 1)
        assertEquals(challengeList[1].challengeId, 2)
    }

    @Test
    @Throws(Exception::class)
    fun insertAndDeleteChallenge() {
        val challenge = Challenge()

        challengeDao.insert(challenge)
        challengeDao.deleteChallenge(1)

        val challengeList = challengeDao.getAllChallenge()
        assertEquals(challengeList.size, 0)
    }

}