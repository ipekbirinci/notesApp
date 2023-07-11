package com.example.tryhilt.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
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
    


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root

        binding.editNotes.setOnClickListener {
            //düzenleyecek
        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){


    }



}