package com.example.plainolnotes4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.NoteEntity
import com.example.data.SampleDataClass

class MainViewModel : ViewModel() {

    val noteList = MutableLiveData<List<NoteEntity>>()

    init {
        noteList.value=SampleDataClass.getNotes()
    }

}