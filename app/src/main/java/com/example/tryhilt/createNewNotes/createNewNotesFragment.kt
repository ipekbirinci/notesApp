package com.example.tryhilt.createNewNotes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tryhilt.R
import com.example.tryhilt.databinding.FragmentCreateNewNotesBinding
import com.example.tryhilt.databinding.FragmentNotesBinding

class createNewNotesFragment : Fragment() {

    companion object {
        fun newInstance() = createNewNotesFragment()
    }

    private lateinit var viewModel: CreateNewNotesViewModel
    private lateinit var binding: FragmentCreateNewNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNewNotesBinding.inflate(inflater, container, false)
        return binding.root

    }


}