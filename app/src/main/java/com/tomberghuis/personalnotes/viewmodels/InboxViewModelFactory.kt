package com.tomberghuis.personalnotes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomberghuis.personalnotes.data.NoteRepository

class InboxViewModelFactory(
        private val repository: NoteRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = InboxViewModel(repository) as T
}