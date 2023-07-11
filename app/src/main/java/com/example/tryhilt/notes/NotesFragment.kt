package com.example.tryhilt.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tryhilt.R
import com.example.tryhilt.adapter.NoteAdapter
import com.example.tryhilt.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private val viewModel by viewModels<NotesViewModel>()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fab.setOnClickListener {
            Log.d("Clicked", "button")
            Navigation.findNavController(it).navigate(R.id.action_notesFragment_to_createNewNotesFragment)
        }

        binding.changeView.setOnClickListener {
            //if button clicked change span count and wrap content
            //set other reyclerview adapter
            Log.d("Clicked", "button")

        }

        val recyclerView = binding.recyclerView
        val adapter = NoteAdapter.create(notes)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

// ViewModel'dan verileri alın
        viewModel.getAllNotes().observe(viewLifecycleOwner, { notes ->
            // Veriler güncellendiğinde RecyclerView'ı güncelleyin
            adapter.submitList(notes)
        })




    }
}