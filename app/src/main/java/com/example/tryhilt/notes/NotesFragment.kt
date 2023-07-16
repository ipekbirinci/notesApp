package com.example.tryhilt.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tryhilt.R
import com.example.tryhilt.adapter.NoteAdapter
import com.example.tryhilt.data.Note
import com.example.tryhilt.data.NoteRepository
import com.example.tryhilt.databinding.FragmentNotesBinding
import com.example.tryhilt.rowclicklistener.RowClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NotesFragment : Fragment() {

    @Inject
    lateinit var noteRepository: NoteRepository
    private val viewModel by viewModels<NotesViewModel>()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        observeViewModel()

        val searcNotes= binding.search

        return binding.root
    }

    private fun observeViewModel() {

        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNote ->

            val adapter = NoteAdapter(listNote, clickListener = object :
                RowClickListener<Note> {
                override fun onRowClick(pos: Int, item: Note) {
                    Log.d("clicked", "card")
                    //detayına gidicek

                    val action = NotesFragmentDirections.actionNotesFragmentToDetailFragment(item)
                    Log.d("Giden","${item.title}")
                    val navController = Navigation.findNavController(binding.root)
                    navController.navigate(action)


                }

                override fun onRowDeleteClick(pos: Int, item: Note) {
                    Log.d("clicked", "delete")
                    lifecycleScope.launch {
                        viewModel.delete(item)
                    }

                }
            }
            )
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = GridLayoutManager(activity, 2)


        }
        viewModel.weatherData.observe(viewLifecycleOwner) { weatherResponse ->
            val temperature = weatherResponse.temperature

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            Log.d("Clicked", "button")
            Navigation.findNavController(it)
                .navigate(R.id.action_notesFragment_to_createNewNotesFragment)

            lifecycleScope.launch {
                viewModel.getWeather()
            }
        }



        binding.changeView.setOnClickListener {
            val layoutManager = binding.recyclerView.layoutManager as? GridLayoutManager
            layoutManager?.let {
                val currentSpanCount = it.spanCount
                val newSpanCount = if (currentSpanCount == 1) 2 else 1
                it.spanCount = newSpanCount
                it.requestLayout()
            }

        }



    }

}
