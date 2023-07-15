package com.example.tryhilt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tryhilt.Dao.NoteDao
/*
@Database(entities = [Note::class], version = 1, exportSchema = false)
//[Note::class], version = 1
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNotesDao():NoteDao
    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE:NoteDatabase?=null

        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE?: synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }

}*/
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao
}
