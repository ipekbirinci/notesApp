package com.example.tryhilt.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteRepository
import com.example.tryhilt.network.ApiRepository
import com.example.tryhilt.responsedata.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {
    @Inject
    lateinit var apiRepository: ApiRepository

    private val _weatherData = MutableLiveData<Double>()
    val weatherData: LiveData<Double>
        get() = _weatherData

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    suspend fun delete(note: Note) {
        repository.delete(note)
    }


    suspend fun getWeather() {

        val x = 40.58
        val y = 29.11
        val call = apiRepository.getWeather(x,y,true)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    weatherResponse?.current_weather?.temperature?.let {
                        val temperature = it
                        _weatherData.postValue(temperature)
                        Log.d("weather", "$temperature")
                    }

                } else {

                }
            }
        })
    }
}


