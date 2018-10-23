package com.tomberghuis.personalnotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


// i guess i don't need to use var due to room magic
// will it blend

@Entity(tableName = "notes")
data class Note(
        val note: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var noteId: Long = 0

//    override fun toString() = note
}
