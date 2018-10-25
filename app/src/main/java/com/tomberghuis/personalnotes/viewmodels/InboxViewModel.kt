package com.tomberghuis.personalnotes.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tomberghuis.personalnotes.data.Note
import com.tomberghuis.personalnotes.data.NoteRepository

class InboxViewModel internal constructor(
        private val noteRepository: NoteRepository
) : ViewModel() {



    private val noteList = MediatorLiveData<List<Note>>()

//    // TODO
//
//    init {
//        growZoneNumber.value = NO_GROW_ZONE
//
//        val livePlantList = Transformations.switchMap(growZoneNumber) {
//            if (it == NO_GROW_ZONE) {
//                plantRepository.getPlants()
//            } else {
//                plantRepository.getPlantsWithGrowZoneNumber(it)
//            }
//        }
//        plantList.addSource(livePlantList, plantList::setValue)
//    }
//
//    fun getPlants() = plantList
//
//    fun setGrowZoneNumber(num: Int) {
//        growZoneNumber.value = num
//    }
//
//    fun clearGrowZoneNumber() {
//        growZoneNumber.value = NO_GROW_ZONE
//    }
//
//    fun isFiltered() = growZoneNumber.value != NO_GROW_ZONE
//
//    companion object {
//        private const val NO_GROW_ZONE = -1
//    }
}