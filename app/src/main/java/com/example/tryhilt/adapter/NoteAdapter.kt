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
import java.util.Locale

class NoteAdapter(
    private val noteList: List<Note>,
    private val clickListener: RowClickListener<Note>
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>(), Filterable, SearchView.OnQueryTextListener {

    private var noteFilterList = ArrayList<Note>()
    private var currentFilterQuery: String = ""

    init {
        noteFilterList.addAll(noteList)
    }

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
                val charSearch = constraint.toString().trim().toLowerCase(Locale.ROOT)
                currentFilterQuery = charSearch
                val resultList = if (charSearch.isEmpty()) {
                    ArrayList(noteList)
                } else {
                    val filteredList = ArrayList<Note>()
                    for (row in noteList) {
                        row.title?.let {
                            if (it.toLowerCase(Locale.ROOT).contains(charSearch)) {
                                filteredList.add(row)
                            }
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = resultList
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged") @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                noteFilterList.clear()
                noteFilterList.addAll(results?.values as ArrayList<Note>)
                notifyDataSetChanged()
            }
        }
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        filter.filter(newText)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        filter.filter(query)
        return true
    }
}
