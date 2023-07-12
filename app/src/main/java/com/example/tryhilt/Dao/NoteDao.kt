package com.example.tryhilt.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tryhilt.data.Note
@Dao
interface NoteDao {
    @Query("SELECT * FROM Note order by id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
   suspend fun delete(note: Note)
}

