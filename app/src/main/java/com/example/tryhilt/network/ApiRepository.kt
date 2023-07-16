package com.example.tryhilt.network

import javax.inject.Inject

class ApiRepository
@Inject constructor(
    private val apiServices: NoteService
)
{
    suspend fun getWeather(X:Double, Y:Double)=apiServices.getWeather(X,Y)
}