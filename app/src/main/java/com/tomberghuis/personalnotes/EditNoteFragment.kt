package com.tomberghuis.personalnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.tomberghuis.personalnotes.databinding.FragmentEditNoteBinding
import com.tomberghuis.personalnotes.viewmodels.EditNoteViewModel
import kotlinx.android.synthetic.main.fragment_edit_note.*
import kotlinx.android.synthetic.main.fragment_inbox.*

class EditNoteFragment : Fragment() {

    lateinit var mEditNoteViewModel: EditNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val noteId = EditNoteFragmentArgs.fromBundle(arguments).noteId

        val factory = Injectors.provideEditNoteViewModelFactory(requireActivity(), noteId)
        mEditNoteViewModel = ViewModelProviders.of(this, factory)
                .get(EditNoteViewModel::class.java)

        val binding = FragmentEditNoteBinding.inflate(inflater, container, false).apply {
            viewModel = mEditNoteViewModel
            setLifecycleOwner(this@EditNoteFragment)
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // add listener to FAB
        fab_save_note.run {
            setOnClickListener {
                // save note
                mEditNoteViewModel.saveNote()
                mEditNoteViewModel.loadTmpNote(tmp_edit_text)
                // TODO navigate to home
                //Navigation.findNavController(view).navigate(R.id.action_edit_note)
            }
        }
    }

}
