package com.example.tryhilt.network

import android.location.Location
import com.example.tryhilt.responsedata.CurrentWeather
import com.example.tryhilt.responsedata.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*interface NoteService {
    @GET("/weather/{location}")
    suspend fun getWeather (
        @Path("location")location:String): Call<CurrentWeather>
}*/

interface NoteService {
    @GET("forecast")
     fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true
    ): Call<WeatherResponse>
}