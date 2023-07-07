package com.example.tryhilt.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tryhilt.data.notes

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<notes>>

    @Insert
    suspend fun insert(note: notes)

    @Update
    suspend fun update(note: notes)

    @Delete
    suspend fun delete(note: notes)
}
