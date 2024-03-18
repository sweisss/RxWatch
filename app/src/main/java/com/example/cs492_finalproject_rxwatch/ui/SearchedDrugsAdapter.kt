package com.example.cs492_finalproject_rxwatch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs492_finalproject_rxwatch.R
import com.example.cs492_finalproject_rxwatch.data.database.SearchedDrug

class SearchedDrugsAdapter : RecyclerView.Adapter<SearchedDrugsAdapter.SearchedDrugsViewHolder>() {
    private var searchedDrugs: MutableList<SearchedDrug> = mutableListOf()

    fun getItemAt(position: Int): SearchedDrug {
        return searchedDrugs[position]
    }

    fun updateDrugs(drugs: MutableList<SearchedDrug>) {
        notifyItemRangeRemoved(0, searchedDrugs.size)
        searchedDrugs = drugs
        notifyItemRangeInserted(0, searchedDrugs.size)
    }

    override fun getItemCount(): Int = searchedDrugs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchedDrugsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.searched_drug_list_item, parent, false)

        return SearchedDrugsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchedDrugsViewHolder, position: Int) {
        holder.bind(searchedDrugs[position])
    }

    class SearchedDrugsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val drugTV: TextView = view.findViewById(R.id.tv_drug_name)

        fun bind(searchedDrug: SearchedDrug) {
            drugTV.text = searchedDrug.drugName
        }
    }
}