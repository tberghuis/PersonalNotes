package com.tomberghuis.personalnotes.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tomberghuis.personalnotes.data.Note
import com.tomberghuis.personalnotes.data.NoteRepository

class InboxViewModel internal constructor(
        private val noteRepository: NoteRepository
) : ViewModel() {



    private val mNoteList = noteRepository.getNotes()
//        public get

//    init {
//
//    }

    fun getInboxNotes():LiveData<List<Note>>{
        return mNoteList
    }


}