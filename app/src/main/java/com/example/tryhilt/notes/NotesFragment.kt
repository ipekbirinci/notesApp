package com.example.tryhilt.notes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
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
    private lateinit var adapter: NoteAdapter
    private val viewModel by viewModels<NotesViewModel>()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)


        viewModel.viewModelScope.launch {
            viewModel.getWeather()
        }

        observeViewModel()

        binding.changeView.setOnClickListener {
            val layoutManager = binding.recyclerView.layoutManager as? GridLayoutManager
            layoutManager?.let {
                Log.d("denme","button")
                val currentSpanCount = it.spanCount
                val newSpanCount = if (currentSpanCount == 1) 2 else 1
                it.spanCount = newSpanCount
                it.requestLayout()
            }

        }

        binding.turnDark.setOnClickListener {
            val layoutManager = binding.recyclerView.layoutManager as? GridLayoutManager
            layoutManager?.let {
                Log.d("denme","button")
                val currentSpanCount = it.spanCount
                val newSpanCount = if (currentSpanCount == 1) 2 else 1
                it.spanCount = newSpanCount
                it.requestLayout()
            }

        }

        return binding.root
    }


    private fun observeViewModel() {

        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNote ->

             adapter = NoteAdapter(listNote, clickListener = object :
                RowClickListener<Note> {
                override fun onRowClick(pos: Int, item: Note) {
                    Log.d("clicked", "card")
                    //detayına gidicek

                    val action = NotesFragmentDirections.actionNotesFragmentToDetailFragment(item)
                    Log.d("Giden", "${item.title}")
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
        viewModel.weatherData.observe(viewLifecycleOwner, Observer { currentWeather ->
            Log.d("noteweather", "$currentWeather")

        })


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                binding.search.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })




        binding.fab.setOnClickListener {

            Log.d("bastııı", "dddd")

            viewModel.viewModelScope.launch {
                viewModel.getWeather()
                viewModel.weatherData.observe(viewLifecycleOwner, Observer { currentWeather ->
                    Log.d("gidiyo", "$currentWeather")
                    val action =
                        NotesFragmentDirections.actionNotesFragmentToCreateNewNotesFragment(
                            currentWeather.toString())
                    Navigation.findNavController(it).navigate(action)
                })


            }


        }

    }
}