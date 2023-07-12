package com.example.tryhilt.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object NoteApi {

    private lateinit var httpClient: OkHttpClient.Builder

    private fun getOkHttpClient(vararg interceptors: Interceptor): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)

        for (interceptor in interceptors) {
            httpClient.addInterceptor(interceptor)
        }

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(httpLoggingInterceptor)

        return httpClient
    }

    private val helpGson: Gson by lazy {
        GsonBuilder().create()
    }

    val noteService: NoteService by lazy {

        httpClient = getOkHttpClient()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(helpGson))
            .client(httpClient.build())
            .build()

        retrofit.create(NoteService::class.java)
    }

}