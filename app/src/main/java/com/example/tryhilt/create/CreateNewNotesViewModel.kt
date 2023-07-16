package com.example.tryhilt.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNewNotesViewModel@Inject constructor (private val repository: NoteRepository): ViewModel() {



    fun insertData(data: Note) {
        viewModelScope.launch {
            repository.insert(data)
        }
    }




}