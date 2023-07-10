package com.example.tryhilt.data

import androidx.lifecycle.LiveData
import com.example.tryhilt.Dao.NoteDao

class NoteRepository ( val notesDao: NoteDao){

    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

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