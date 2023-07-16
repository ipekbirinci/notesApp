package com.example.tryhilt.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tryhilt.R
import com.example.tryhilt.data.Note
import com.example.tryhilt.databinding.FragmentUpdateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {

    private val  viewModel by viewModels<UpdateViewModel>()
    private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=  FragmentUpdateBinding.inflate(inflater,container,false)
        val args = UpdateFragmentArgs.fromBundle(requireArguments())
        val note: Note = args.updateNote

        //datadan veri güncelleme
        binding.updateTitle.setText(note.title)
        binding.updateContext.setText(note.context)

        binding.updateButton.setOnClickListener {
            note.title=binding.updateTitle.text.toString()
            note.context = binding.updateContext.text.toString()
            viewModel.update(note)
            Navigation.findNavController(it).navigate(R.id.action_updateFragment_to_notesFragment)

        }

        return binding.root
    }


}