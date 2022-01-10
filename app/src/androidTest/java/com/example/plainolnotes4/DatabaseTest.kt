package com.example.plainolnotes4

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.data.DatabaseApp
import com.example.data.NoteDAO
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var dao: NoteDAO
    private lateinit var databaseApp: DatabaseApp

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.plainolnotes4", appContext.packageName)
    }
}