package com.example.tryhilt.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/*
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

}*/
@Entity(tableName = "Note")
@Parcelize
data class Note(
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "context")
    var context: String?,
    @ColumnInfo(name = "date")
    var date: String?,
    @ColumnInfo(name = "weather_location")
    var weatherLocation: String?
): Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}