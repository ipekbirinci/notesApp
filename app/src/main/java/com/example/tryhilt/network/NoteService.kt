package com.example.tryhilt.network

import com.example.tryhilt.responsedata.CurrentWeather
import com.example.tryhilt.responsedata.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NoteService {
    @GET("weather")
    suspend fun getWeather (
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): CurrentWeather
}