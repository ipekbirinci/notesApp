package com.example.tryhilt.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Note")
@Parcelize
data class Note(
    @ColumnInfo(name = "title")
    var title: String?=null,
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