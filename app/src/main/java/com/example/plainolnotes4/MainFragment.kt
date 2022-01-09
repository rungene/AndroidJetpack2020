package com.example.plainolnotes4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.NoteListAdapter
import com.example.plainolnotes4.databinding.MainFragmentBinding

class MainFragment : Fragment(), NoteListAdapter.ListItemListener{


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter:NoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding = MainFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(binding.recyclerView){
            setHasFixedSize(true)
            val divider =DividerItemDecoration(
                context,LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        viewModel.noteList.observe(viewLifecycleOwner, Observer {
            Log.i("note_logging", it.toString())
            adapter = NoteListAdapter(it,this@MainFragment)
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager=LinearLayoutManager(activity)
        })
        return binding.root

    }

    override fun onItemClick(noteId: Int) {
      Log.i(TAG,"onItemClick, received note id $noteId")
        val action =MainFragmentDirections.actionMainFragmentToEditFragment(noteId)
        findNavController().navigate(action)
    }

}