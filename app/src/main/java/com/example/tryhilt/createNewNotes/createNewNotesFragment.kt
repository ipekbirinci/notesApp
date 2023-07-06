package com.example.tryhilt.createNewNotes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tryhilt.R

class createNewNotesFragment : Fragment() {

    companion object {
        fun newInstance() = createNewNotesFragment()
    }

    private lateinit var viewModel: CreateNewNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_new_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateNewNotesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}