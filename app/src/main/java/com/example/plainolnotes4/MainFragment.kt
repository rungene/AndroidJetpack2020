package com.example.plainolnotes4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)

        binding = MainFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(binding.recyclerView){
            setHasFixedSize(true)
            val divider =DividerItemDecoration(
                context,LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        viewModel.noteList?.observe(viewLifecycleOwner, Observer {
            Log.i("note_logging", it.toString())
            adapter = NoteListAdapter(it,this@MainFragment)
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager=LinearLayoutManager(activity)
        })
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val menuId =
            if (this::adapter.isInitialized &&
                    adapter.notesSelected.isNotEmpty()){
                R.menu.menu_main_item_selected
            }else{
                R.menu.menu_main
            }


        inflater.inflate(menuId,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.menu_sample_data -> addSampleData()
            R.id.delete_action -> deleteSelectedNotes()
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun deleteSelectedNotes(): Boolean {
    return true
    }

    private fun addSampleData(): Boolean {

        viewModel.addSampleData()

        return true
    }

    override fun onItemClick(noteId: Int) {
      Log.i(TAG,"onItemClick, received note id $noteId")
        val action =MainFragmentDirections.actionMainFragmentToEditFragment(noteId)
        findNavController().navigate(action)
    }

    override fun onItemSelectedChanged() {
        requireActivity().invalidateOptionsMenu()
    }

}