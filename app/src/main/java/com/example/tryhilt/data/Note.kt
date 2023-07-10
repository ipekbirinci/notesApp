package com.example.tryhilt.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="context")
    val context: String,
    @ColumnInfo(name="date")
    val date: Long,
    @ColumnInfo(name = "weather_location")
    val weatherLocation: String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

}

