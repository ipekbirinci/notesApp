package com.example.tryhilt.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.data.NoteRepository

class NotesViewModel : ViewModel() {

   //livedata
    val allNotes:LiveData<List<Note>>
    val repository:NoteRepository
    init{
        val dao=NoteDatabase.getDatabase(application).getNotesDao()
        repository=NoteRepository(dao)
        allNotes=repository.allNotes
    }
    //get all notes
}