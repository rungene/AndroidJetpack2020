package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.*

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class Database :RoomDatabase() {

    //register DAO
    abstract fun noteDao() :NoteDAO?

    //initialize DB
    companion object{
        
    }

}