package com.example.plainolnotes4

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        requireActivity().title=
            if (args.noteId == NEW_NOTE_ID){
                getString(R.string.new_note)
            }else{
                getString(R.string.edit_note)
            }

        viewModel = ViewModelProvider(this).get(EditViewModel::class.java)

        binding= EditFragmentBinding.inflate(inflater,container,false)
        binding.editText.setText("")

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    returnAndSave()
                }
            }
        )
//display the selected note text value
        viewModel.currentNote.observe(viewLifecycleOwner, Observer {
            binding.editText.setText(it.text)
        })
        //retrieve the data
        viewModel.getNoteById(args.noteId)


        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            android.R.id.home -> returnAndSave()

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun returnAndSave(): Boolean {

//close the soft keyboard
        val imm = requireActivity()
            .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.hideSoftInputFromWindow(binding.root.windowToken,0)

        //get value that the user has typed in,assign that to the currentNote object that is in VM
        viewModel.currentNote.value?.text =binding.editText.text.toString()
        viewModel.updateNote()


        findNavController().navigateUp()

      return  true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        with(binding.editText){
            outState.putString(NOTES_TEXT_KEY,text.toString())
            outState.putInt(CURSOR_POSITION_KEY,selectionStart)
        }
        super.onSaveInstanceState(outState)
    }


}