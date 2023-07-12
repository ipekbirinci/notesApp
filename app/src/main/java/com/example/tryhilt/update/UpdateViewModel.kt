package com.example.tryhilt.update

import android.app.Application
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

    fun update(noteId: String, title: String, content: String) {
        viewModelScope.launch {
            val note = Note(noteId, title, content,null)
            repository.update(note)
        }
    }


}