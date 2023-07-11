package com.example.tryhilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tryhilt.R
import com.example.tryhilt.data.Note

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val titleTextView: TextView = itemView.findViewById(R.id.note_title)
        private val noteContextTextView: TextView = itemView.findViewById(R.id.note_context)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(note: Note) {
            titleTextView.text = note.title
            noteContextTextView.text = note.context
        }

        override fun onClick(view: View) {
            // CardView'a tıklandığında yapılacak işlemler
            //butona tıklanırsa silecek
            val note = notes[adapterPosition]


        }
    }
}
