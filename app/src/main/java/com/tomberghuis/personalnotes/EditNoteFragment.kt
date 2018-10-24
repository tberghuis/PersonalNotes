package com.tomberghuis.personalnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tomberghuis.personalnotes.databinding.FragmentEditNoteBinding
import com.tomberghuis.personalnotes.viewmodels.EditNoteViewModel

class EditNoteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val factory = Injectors.provideEditNoteViewModelFactory(requireActivity(), -1L)
        val editNoteViewModel = ViewModelProviders.of(this, factory)
                .get(EditNoteViewModel::class.java)

        val binding = FragmentEditNoteBinding.inflate(inflater, container, false).apply {
//            view_model = editNoteViewModel
        }
        return binding.root
    }

}
