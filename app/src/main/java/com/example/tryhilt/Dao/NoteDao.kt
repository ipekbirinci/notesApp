package com.example.tryhilt.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tryhilt.data.Note
@Dao
interface NoteDao {
    @Query("SELECT * FROM Note order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}

