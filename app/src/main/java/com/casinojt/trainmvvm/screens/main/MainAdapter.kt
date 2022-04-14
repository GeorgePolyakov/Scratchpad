package com.casinojt.trainmvvm.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.model.AppNote

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var  mListNotes = emptyList<AppNote>()
    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        var noteName: TextView = view.findViewById(R.id.item_note_name)
        var textNote: TextView = view.findViewById(R.id.item_note_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
            return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
            holder.textNote.text = mListNotes[position].text
            holder.noteName.text = mListNotes[position].name
    }

    override fun getItemCount(): Int  = mListNotes.size

    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }
}