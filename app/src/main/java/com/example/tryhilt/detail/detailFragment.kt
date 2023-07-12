package com.example.tryhilt.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tryhilt.R
import com.example.tryhilt.data.Note
import com.example.tryhilt.databinding.FragmentCreateNewNotesBinding
import com.example.tryhilt.databinding.FragmentDetailBinding

class detailFragment : Fragment() {


    private val viewModel by viewModels<DetailViewModel> ()
    private lateinit var binding: FragmentDetailBinding
    private val args: detailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = detailFragmentArgs.fromBundle(requireArguments())
        val noteId: Note = args.note

        Log.d("bakalım", "${noteId.title}")
        binding.detailTitle.text = noteId.title.toString()
        binding.detailText.text = noteId.context.toString()
        binding.detailWeather.text = noteId.weatherLocation.toString()
        binding.detailDate.text = noteId.date.toString()

        binding.editNotes.setOnClickListener {
            //düzenleyecek
        }
    }


}