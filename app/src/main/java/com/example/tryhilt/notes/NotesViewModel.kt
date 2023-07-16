package com.example.tryhilt.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteRepository
import com.example.tryhilt.di.NetworkModule
import com.example.tryhilt.network.ApiRepository
import com.example.tryhilt.responsedata.CurrentWeather
import com.example.tryhilt.responsedata.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {
    @Inject
    lateinit var apiRepository: ApiRepository

    private val _weatherData = MutableLiveData<CurrentWeather>()
    val weatherData: LiveData<CurrentWeather>
        get() = _weatherData

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    suspend fun delete(note: Note) {
        repository.delete(note)
    }


    suspend fun getWeather(latitude:Double,longitude:Double) {
        val latitude = 41.0
        val longitude = 29.0

        try {
            val weatherResponse = apiRepository.getWeather(latitude, longitude)
            _weatherData.postValue(weatherResponse)
            Log.d("Weather","${_weatherData}")

        } catch (e: Exception) {
        }
    }
}


