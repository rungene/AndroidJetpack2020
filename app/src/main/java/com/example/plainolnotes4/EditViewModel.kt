package com.example.plainolnotes4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.DatabaseApp
import com.example.data.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditViewModel(app: Application) : AndroidViewModel(app) {

    private val database = DatabaseApp.getInstance(app)
    val currentNote = MutableLiveData<NoteEntity>()

    fun getNoteById(noteId: Int) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val note =
                //if i get a value of zero that means it is a new note but if not then i need to
                    //retrive data from db
                    if (noteId != NEW_NOTE_ID) {
                        database?.noteDao()?.getNoteById(noteId)
                    } else {
                        //creating a new instance of note entity class
                        NoteEntity()
                    }
                //regardless if i have a new note object or have gotten one from db ,i will assign it
                //to the current note
                currentNote.postValue(note!!)
            }
        }
    }
}