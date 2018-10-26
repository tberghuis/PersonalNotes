package com.tomberghuis.personalnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.tomberghuis.personalnotes.adapters.NoteAdapter
import com.tomberghuis.personalnotes.databinding.FragmentInboxBinding
import com.tomberghuis.personalnotes.viewmodels.InboxViewModel
import kotlinx.android.synthetic.main.fragment_inbox.*

class InboxFragment : Fragment() {

    private lateinit var viewModel: InboxViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentInboxBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = Injectors.provideInboxViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(InboxViewModel::class.java)

        val adapter = NoteAdapter()
        binding.inboxNoteList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // add listener to FAB

        fab_add_note.run {
            setOnClickListener {
                // TODO navigate to editnotefragment

                // could not get nav graph argument default value to work
                var bundle = bundleOf("noteId" to -1L)
                Navigation.findNavController(view).navigate(R.id.action_edit_note,bundle)
            }
        }
    }


    private fun subscribeUi(adapter: NoteAdapter) {
        viewModel.getInboxNotes().observe(viewLifecycleOwner, Observer { notes ->
            if (notes != null) adapter.submitList(notes)
        })
    }



//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentGardenBinding.inflate(inflater, container, false)
//        val adapter = GardenPlantingAdapter(binding.root.context)
//        binding.gardenList.adapter = adapter
//        subscribeUi(adapter, binding)
//        return binding.root
//    }
//
//    private fun subscribeUi(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {
//        val factory = InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
//        val viewModel = ViewModelProviders.of(this, factory)
//                .get(GardenPlantingListViewModel::class.java)
//
//        viewModel.gardenPlantings.observe(viewLifecycleOwner, Observer { plantings ->
//            binding.hasPlantings = (plantings != null && plantings.isNotEmpty())
//        })
//
//        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner, Observer { result ->
//            if (result != null && result.isNotEmpty())
//                adapter.submitList(result)
//        })
//    }
}
