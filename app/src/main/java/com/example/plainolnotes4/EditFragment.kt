package com.example.plainolnotes4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.plainolnotes4.databinding.EditFragmentBinding

class EditFragment : Fragment() {

    private lateinit var viewModel: EditViewModel
    private val args : EditFragmentArgs by navArgs()
    private lateinit var binding:EditFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    // getting a reference to the activity that owns this fragment,get a reference to supportActionBar
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(EditViewModel::class.java)

        binding= EditFragmentBinding.inflate(inflater,container,false)
        binding.editText.setText("you selected note number ${args.noteId}")

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    returnAndSave()
                }
            }
        )

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            android.R.id.home -> returnAndSave()

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun returnAndSave(): Boolean {
        findNavController().navigateUp()

      return  true
    }


}