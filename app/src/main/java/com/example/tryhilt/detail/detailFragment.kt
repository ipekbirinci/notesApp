package com.example.tryhilt.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tryhilt.R
import com.example.tryhilt.databinding.FragmentCreateNewNotesBinding
import com.example.tryhilt.databinding.FragmentDetailBinding

class detailFragment : Fragment() {

    companion object {
        fun newInstance() = detailFragment()
    }

    private lateinit var viewModel: DetailViewModel
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



}