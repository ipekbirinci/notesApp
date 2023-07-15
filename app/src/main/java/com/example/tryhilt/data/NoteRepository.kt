package com.example.tryhilt.data

import androidx.lifecycle.LiveData
import com.example.tryhilt.Dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class NoteRepository@Inject constructor
    ( private val notesDao: NoteDao){

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
