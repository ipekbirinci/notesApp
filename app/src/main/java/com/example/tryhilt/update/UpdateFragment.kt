package com.example.tryhilt.update

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.tryhilt.R
import com.example.tryhilt.data.Note
import com.example.tryhilt.databinding.FragmentUpdateBinding
import com.example.tryhilt.detail.detailFragmentArgs

class UpdateFragment : Fragment() {

    private val  viewModel by viewModels<UpdateViewModel>()
    private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=  FragmentUpdateBinding.inflate(inflater,container,false)
        val args = UpdateFragmentArgs.fromBundle(requireArguments())
        val noteId: Note = args.updateNote

        binding.updateButton.setOnClickListener {
            val title = binding.updateTitle.text.toString()
            val content = binding.updateContext.text.toString()
            viewModel.update(noteId.id.toString(), title, content)
            Navigation.findNavController(it).navigate(R.id.action_updateFragment_to_notesFragment)

        }

        return binding.root
    }



}