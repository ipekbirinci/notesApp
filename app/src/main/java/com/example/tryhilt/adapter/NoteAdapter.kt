package com.example.tryhilt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tryhilt.R
import com.example.tryhilt.data.Note
import com.example.tryhilt.databinding.CardViewBinding
import com.example.tryhilt.rowclicklistener.RowClickListener


class NoteAdapter(
    private var noteList: List<Note>,
    private var clickListener: RowClickListener<Note>
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardViewBinding = DataBindingUtil.inflate(inflater, R.layout.card_view, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = noteList[position]

        holder.binding.noteTitle.text = currentNote.title.toString()
        holder.binding.noteContext.text = currentNote.context.toString()

        holder.binding.deleteCard.setOnClickListener {
            clickListener.onRowDeleteClick(position, currentNote)
            Log.d("asd","${currentNote.id}")
        }
        holder.binding.cardCell.setOnClickListener{
            clickListener.onRowClick(position, currentNote)

        }
    }

    override fun getItemCount(): Int = noteList.size
}

