package com.example.tryhilt.data

import androidx.lifecycle.LiveData
import com.example.tryhilt.Dao.NoteDao
import javax.inject.Inject

class NoteRepository@Inject constructor
    ( private val notesDao: NoteDao,

      ){

    fun getAllNotes(): LiveData<List<Note>> {
        return notesDao.getAllNotes()
    }


    suspend fun insert(note:Note){
        notesDao.insert(note)
    }

    suspend fun delete(note: Note){
        notesDao.delete(note)
    }
    suspend fun update(note: Note){
        notesDao.update(note)
    }

}
