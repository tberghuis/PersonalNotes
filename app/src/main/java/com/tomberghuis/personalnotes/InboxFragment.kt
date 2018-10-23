package com.tomberghuis.personalnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tomberghuis.personalnotes.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentInboxBinding.inflate(inflater, container, false)
        return binding.root
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
