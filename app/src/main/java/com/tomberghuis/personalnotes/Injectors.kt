package com.tomberghuis.personalnotes

import android.content.Context
import com.tomberghuis.personalnotes.data.AppDatabase
import com.tomberghuis.personalnotes.data.NoteRepository
import com.tomberghuis.personalnotes.viewmodels.EditNoteViewModelFactory

object Injectors {

    private fun getNoteRepository(context: Context): NoteRepository {
        return NoteRepository.getInstance(AppDatabase.getInstance(context).noteDao())
    }

    fun provideEditNoteViewModelFactory(
            context: Context,
            noteId: Long
    ): EditNoteViewModelFactory {
        return EditNoteViewModelFactory(getNoteRepository(context),
                noteId)
    }
}
