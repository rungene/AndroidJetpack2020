package com.example.plainolnotes4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.DatabaseApp
import com.example.data.NoteEntity
import com.example.data.SampleDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(app:Application) : AndroidViewModel(app) {

    private val database =DatabaseApp.getInstance(app)

    val noteList = database?.noteDao()?.getAll()


     fun addSampleData(){
         viewModelScope.launch {
             withContext(Dispatchers.IO){
                 val sampleNotes = SampleDataClass.getNotes()
                 database?.noteDao()?.insertAll(sampleNotes)
             }
         }

     }

    fun deleteNotes(notesSelected: List<NoteEntity>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){

                database?.noteDao()?.deleteNotes(notesSelected)
            }
        }

    }

}