package com.example.tryhilt.create

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.Dao.NoteDao
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteDatabase
import kotlinx.coroutines.launch

class CreateNewNotesViewModel (application: Application): AndroidViewModel(application) {
    private val myDao: NoteDao
    private val allData: LiveData<List<Note>>

    init {
        val database = NoteDatabase.getDatabase(application)
        myDao = database.getNotesDao()
        allData = myDao.getAllNotes()
    }

    fun insertData(data: Note) {
        viewModelScope.launch {
            myDao.insert(data)
        }
    }


}