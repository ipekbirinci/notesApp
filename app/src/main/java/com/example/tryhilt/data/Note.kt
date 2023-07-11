package com.example.tryhilt.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(
    @ColumnInfo(name="title")
    var title: String?,
    @ColumnInfo(name="context")
    var context: String?,
    @ColumnInfo(name="date")
    var date: String?,
    @ColumnInfo(name = "weather_location")
    var weatherLocation: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}

