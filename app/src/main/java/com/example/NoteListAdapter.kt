package com.example

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.NoteEntity
import com.example.plainolnotes4.databinding.ListItemBinding

class NoteListAdapter (private val noteList: List<NoteEntity>) :
RecyclerView.Adapter<NoteListAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView)
    {
val binding =ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}