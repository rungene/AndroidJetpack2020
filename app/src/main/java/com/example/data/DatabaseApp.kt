package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.*

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseApp :RoomDatabase() {

    //register DAO
    abstract fun noteDao() :NoteDAO?

    //initialize DB
    companion object{

        private var INSTANCE : DatabaseApp?=null

        fun getInstance(context:Context):DatabaseApp?{
            if (INSTANCE== null){
   //ensures initialization of DB is only executed once at a time
                synchronized(DatabaseApp::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseApp::class.java,
                        "notes.db"
                    ).build()
                }
            }

            return INSTANCE
        }

    }

}