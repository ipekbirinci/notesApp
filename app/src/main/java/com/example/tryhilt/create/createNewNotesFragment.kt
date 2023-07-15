package com.example.tryhilt.create

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tryhilt.R
import com.example.tryhilt.databinding.FragmentCreateNewNotesBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
@AndroidEntryPoint
class createNewNotesFragment : Fragment() {

    private val viewModel by viewModels<CreateNewNotesViewModel>()
    private lateinit var binding: FragmentCreateNewNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateNewNotesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {
            val title = binding.titleofnote.text.toString()
            val noteContext = binding.newNote.text.toString()
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val note = com.example.tryhilt.data.Note(title,noteContext,currentDate,"weather")
            viewModel.insertData(note)
            Toast.makeText(requireContext(), "Notes Created Successful", Toast.LENGTH_SHORT).show()
            Log.d("title","${title}")
            Log.d("title","${noteContext}")
            Log.d("title","${note}")
            Navigation.findNavController(it).navigate(R.id.action_createNewNotesFragment_to_notesFragment)

        }

        }
    }


