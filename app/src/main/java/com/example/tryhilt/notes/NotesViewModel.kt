package com.example.tryhilt.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tryhilt.Dao.NoteDao
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.data.NoteRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
    }

    // LiveData
    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    // Diğer işlevler...
}

