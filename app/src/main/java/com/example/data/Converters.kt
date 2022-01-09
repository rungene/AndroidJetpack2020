package com.example.data

import androidx.room.TypeConverter
import java.util.*

class Converters {
    //used when you want to take an integer value from db and pass it back to Kotlin code as a
    // date object
    @TypeConverter
    fun fromTimeStamp(value:Long):Date{
        return Date(value)
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date):Long{
        return date.time
    }
}
