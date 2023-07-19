package com.example.tryhilt.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tryhilt.R
import com.example.tryhilt.data.Note
import com.example.tryhilt.databinding.CardViewBinding
import com.example.tryhilt.rowclicklistener.RowClickListener
import java.lang.Character.toLowerCase
import java.util.Locale
class NoteAdapter(
    private val noteList: List<Note>,
    private val clickListener: RowClickListener<Note>
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>(), Filterable {

    private var noteFilterList = noteList.toMutableList()

    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.card_view, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = noteFilterList[position]

        holder.binding.noteTitle.text = currentNote.title
        holder.binding.noteContext.text = currentNote.context

        holder.binding.deleteCard.setOnClickListener {
            clickListener.onRowDeleteClick(position, currentNote)
            Log.d("asd", "${currentNote.id}")
        }

        holder.binding.cardCell.setOnClickListener {
            clickListener.onRowClick(position, currentNote)
        }
    }

    override fun getItemCount(): Int = noteFilterList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                //Aranan yazı
                val charSearch = constraint.toString()
                //Arama alanında bir yazı aranmadıysa tüm notları noteFilterList'e aktarıyoruz
                if (charSearch.isEmpty()) {
                    noteFilterList = noteList.toMutableList()
                } else {
                    val resultList = ArrayList<Note>()
                    for (row in noteList) {
                        row.title?.let {
                            if (it.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                                resultList.add(row)
                            }
                        }
                    }
                    noteFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = noteFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                noteFilterList = results?.values as? MutableList<Note> ?: mutableListOf()
                notifyDataSetChanged()
            }
        }
    }

}
