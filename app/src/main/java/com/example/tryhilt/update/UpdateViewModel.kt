package com.example.tryhilt.update

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.data.NoteRepository
import kotlinx.coroutines.launch

class UpdateViewModel (application: Application) :AndroidViewModel(application) {

    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(noteDao)
    }

    fun update(note:Note) {
        viewModelScope.launch {
            repository.update(note)
            Log.d("title","${note.title}")
        }
    }


}