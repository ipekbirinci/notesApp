package com.example.tryhilt.notes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.tryhilt.R

class notesFragment : Fragment() {

    companion object {
        fun newInstance() = notesFragment()
    }

    private lateinit var viewModel: NotesViewModel
    private lateinit var binding: notesFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root




    }




}