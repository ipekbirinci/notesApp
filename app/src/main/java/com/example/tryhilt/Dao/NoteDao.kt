package com.example.tryhilt.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tryhilt.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    //son tarih, title,içerik değiş,yeni data class
    suspend fun update(note: Note)

    @Delete
    //id gelcek o idliyi silcek
    suspend fun delete(note: Note)
}
