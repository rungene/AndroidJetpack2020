package com.example.plainolnotes4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.DatabaseApp
import com.example.data.NoteEntity
import com.example.data.SampleDataClass

class MainViewModel(app:Application) : AndroidViewModel(app) {

    private val database =DatabaseApp.getInstance(app)

    val noteList = MutableLiveData<List<NoteEntity>>()

    init {
        noteList.value=SampleDataClass.getNotes()
    }

}