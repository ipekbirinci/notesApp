package com.example.tryhilt.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tryhilt.R
import com.example.tryhilt.adapter.NoteAdapter
import com.example.tryhilt.adapter.NoteListAdapter
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
        // Önce bir değişken oluşturun ve varsayılan olarak "card view" modunu ayarlayın
        var isCardViewMode = true

        binding.changeView.setOnClickListener {
            Log.d("Clicked", "button")

            // Görünüm modunu değiştirin
            isCardViewMode = !isCardViewMode

            if (isCardViewMode) {
                // Card View modunda ise
                viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
                    val layoutManager = GridLayoutManager(requireContext(),2)
                    binding.recyclerView.layoutManager = layoutManager
                    binding.recyclerView.adapter = NoteAdapter(notesList)
                }
            } else {
                // List View modunda ise
                viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
                    val layoutManager = LinearLayoutManager(requireContext())
                    binding.recyclerView.layoutManager = layoutManager
                    binding.recyclerView.adapter = NoteListAdapter(notesList)
                }
            }
        }

        viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
            val layoutManager = GridLayoutManager(requireContext(),2)
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = NoteAdapter(notesList)
        }

    }
}