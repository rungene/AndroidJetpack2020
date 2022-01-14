package com.example.plainolnotes4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.DatabaseApp
import com.example.data.NoteEntity

class EditViewModel (app:Application): AndroidViewModel(app) {

    private val database = DatabaseApp.getInstance(app)
    val currentNote = MutableLiveData<NoteEntity>()

    // TODO: Implement the ViewModel
}