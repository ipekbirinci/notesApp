package com.example.tryhilt.notes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.Dao.NoteDao
import com.example.tryhilt.adapter.NoteAdapter
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.data.NoteRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
class NotesViewModel(application: Application) : AndroidViewModel(Application()) {

    private val repository: NoteRepository


    init {
        val noteDao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(noteDao)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }
    suspend fun delete(note:Note){
        return repository.delete(note)
    }

    fun getWeather(){

    }
}*/
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    suspend fun delete(note: Note) {
        repository.delete(note)
    }


    fun getWeather() {

    }
}


