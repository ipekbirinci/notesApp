package com.example.tryhilt.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val context: String,
    val date: Long,
    @ColumnInfo(name = "weather_location")
    val weatherLocation: String
)

