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

class NoteListAdapter (private val noteList: List<NoteEntity>,
private val listener:ListItemListener
                       ) :
RecyclerView.Adapter<NoteListAdapter.ViewHolder>()
{
    val notesSelected = arrayListOf<NoteEntity>()

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

    //This function is called each time data is passed to one of the recycled views, rows or tiles.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = noteList[position]
        with(holder.binding){
            textNote.text=note.text
            root.setOnClickListener{
                listener.onItemClick(note.id)
            }
            floatingActionButton.setOnClickListener {
                if (notesSelected.contains(note)){
                    notesSelected.remove(note)
                    floatingActionButton.setImageResource(R.drawable.ic_note)
                }else{
                    notesSelected.add(note)
                    floatingActionButton.setImageResource(R.drawable.ic_check)
                }
            }
                //setting the icon in the run time either when the fragment first pop up, or as the
            //list scrolls
            floatingActionButton.setImageResource(
                if (notesSelected.contains(note)){
                    R.drawable.ic_check
                }else{
                    R.drawable.ic_note
                }
            )

        }

    }

    //called by recyclerview to find out how many data items are there in a list
    override fun getItemCount()=noteList.size

    interface ListItemListener{

        fun onItemClick(noteId:Int)
    }


}