package com.example.plainolnotes4

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.data.DatabaseApp
import com.example.data.NoteDAO
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var dao: NoteDAO
    private lateinit var databaseApp: DatabaseApp


    @Before
    fun createDb(){
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //initialize db
        //inMemoryDatabaseBuilder ensures your not storing the db in the persistence storage during
       // test
        databaseApp = Room.inMemoryDatabaseBuilder(appContext,DatabaseApp::class.java)
            .allowMainThreadQueries()
            .build()

            //initialize DAO object
        dao = databaseApp.noteDao()!!

    }



    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.plainolnotes4", appContext.packageName)
    }

    @After
    fun closeDB(){
        databaseApp.close()
    }
}