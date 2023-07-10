package com.example.tryhilt.notes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tryhilt.R
import com.example.tryhilt.databinding.FragmentNotesBinding

class notesFragment : Fragment() {

    private lateinit var viewModel: NotesViewModel
    private lateinit var binding: FragmentNotesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)


        viewModel.getAllNotes()

        binding.fab.setOnClickListener {
            Log.d("Clicked","button")
            Navigation.findNavController(it).navigate(R.id.action_notesFragment_to_createNewNotesFragment)
        }

        binding.changeView.setOnClickListener {
            //if button clicked change span count and wrap content
            //set other reyclerview adapter
        }
        return binding.root
    }

}