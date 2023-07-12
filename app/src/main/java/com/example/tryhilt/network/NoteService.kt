package com.example.tryhilt.network

import retrofit2.http.GET

interface NoteService {

    @GET("/requests")
    fun getAllRequests()
}