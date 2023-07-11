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
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.data.NoteRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NoteRepository) : ViewModel() {

     fun getData() {
        viewModelScope.launch {
            repository.getAllNotes().map {
                it.forEach { note->


                    Log.d("VERİVERİ",note.toString())
                }
            }
        }
    }
}

