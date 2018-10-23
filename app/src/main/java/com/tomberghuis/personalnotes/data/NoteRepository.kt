package com.tomberghuis.personalnotes.data

import java.util.concurrent.Executors

class NoteRepository private constructor(private val noteDao: NoteDao) {


    fun createNote(note: String) {
        Executors.newSingleThreadExecutor().execute {
//            val note = Note()
            noteDao.insert(Note(note))
        }
    }

    fun getNotes() = noteDao.getNotes()

    fun getNote(noteId: Long) = noteDao.getNote(noteId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDao) =
                instance ?: synchronized(this) {
                    instance ?: NoteRepository(noteDao).also { instance = it }
                }
    }
}
