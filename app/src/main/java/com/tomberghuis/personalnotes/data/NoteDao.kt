package com.tomberghuis.personalnotes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNote(noteId: Long): LiveData<Note>


//    @Query("SELECT note FROM notes WHERE id = :noteId")
//    fun getNoteData(noteId: Long): String

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(plants: List<Plant>)

    @Insert
    fun insert(note: Note): Long
}
