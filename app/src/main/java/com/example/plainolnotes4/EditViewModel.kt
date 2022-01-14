package com.example.plainolnotes4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.data.DatabaseApp

class EditViewModel (app:Application): AndroidViewModel(app) {

    private val database = DatabaseApp.getInstance(app)
    // TODO: Implement the ViewModel
}