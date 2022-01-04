package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.NoteEntity
import com.example.plainolnotes4.R
import com.example.plainolnotes4.databinding.ListItemBinding

class NoteListAdapter (private val noteList: List<NoteEntity>) :
RecyclerView.Adapter<NoteListAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView)
    {
val binding =ListItemBinding.bind(itemView)
    }
//called each time new list is generated, gets those references to views & then returns viewholder
    //object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater =LayoutInflater.from(parent.context)
      val view = inflater.inflate(R.layout.list_item,parent,false)

    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    //called by recyclerview to find out how many data items are there in a list
    override fun getItemCount()=noteList.size


}