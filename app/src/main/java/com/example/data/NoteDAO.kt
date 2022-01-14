package com.example.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {

    //this function can be used to insert a new note or update the existing note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)

    //inserting a bunch of notes, if they already exist in db throw away the new ones
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(notes: List<NoteEntity>)

    //returns a LiveData object,allowing to observe the db table, use reactive programming using an
    //an observer
    @Query("SELECT * FROM notes ORDER BY date ASC")
    fun getAll() : LiveData<List<NoteEntity>>

    //returns a single note object
    //returns a NoteEntity object, it is nullable
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id:Int) : NoteEntity?

    //reports how many rows are there in the db- easily query the db table
    @Query("SELECT COUNT(*) from notes")
    fun getCount() :Int

    @Delete
    fun deleteNotes(notesSelected: List<NoteEntity>):Int

    @Query("DELETE FROM notes")
    fun deleteAllNotes():Int
}