package com.tomberghuis.personalnotes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomberghuis.personalnotes.data.NoteRepository

class EditNoteViewModelFactory(
        private val noteRepository: NoteRepository,
        private val noteId: Long
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditNoteViewModel(noteRepository, noteId) as T
    }
}
