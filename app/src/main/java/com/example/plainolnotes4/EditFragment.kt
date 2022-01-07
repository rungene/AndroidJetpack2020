package com.example.plainolnotes4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding= EditFragmentBinding.inflate(inflater,container,false)
        binding.editText.setText("you selected note number ${args.noteId}")

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditViewModel::class.java)

    }

}