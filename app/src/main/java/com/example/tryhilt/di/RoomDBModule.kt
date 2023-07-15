package com.example.tryhilt.di

import android.content.Context
import androidx.room.Room
import com.example.tryhilt.Dao.NoteDao
import com.example.tryhilt.data.NoteDatabase
import com.example.tryhilt.network.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDBModule {
    @Provides
    @Singleton
    fun provideNoteRoomDB(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideNoteDAO(recipeRoomDB: NoteDatabase): NoteDao {
        return recipeRoomDB.noteDao()
    }
}