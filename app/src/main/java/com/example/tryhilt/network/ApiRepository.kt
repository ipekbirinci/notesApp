package com.example.tryhilt.network

import com.example.tryhilt.responsedata.CurrentWeather
import javax.inject.Inject

class ApiRepository
@Inject constructor(
    private val apiServices: NoteService
)
{
   fun getWeather(x:Double,y:Double,current_weather:Boolean)=apiServices.getWeather(x,y,current_weather)
}