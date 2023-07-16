package com.example.tryhilt.update

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    fun update(note: Note) {
        viewModelScope.launch {
            repository.update(note)
            Log.d("title", "${note.title}")
        }
    }


}