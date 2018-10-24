package com.tomberghuis.personalnotes.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tomberghuis.personalnotes.data.NoteRepository

class EditNoteViewModel(
        noteRepository: NoteRepository,
        private val noteId: Long
) : ViewModel() {

    var note: MutableLiveData<String> = MutableLiveData<String>().apply{
        var initialNote = ""
        // new notes have noteId = -1L
//        if(noteId!=-1L) initialNote = noteRepository.getNoteData(noteId)
        if(noteId!=-1L) initialNote = noteRepository.getNote(noteId).value?.note ?: ""
        postValue(initialNote)
    }


}
