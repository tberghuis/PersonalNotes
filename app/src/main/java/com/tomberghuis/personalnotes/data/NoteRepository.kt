package com.tomberghuis.personalnotes.data

import android.provider.Contacts
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.Channel
import java.util.concurrent.Executors

class NoteRepository private constructor(private val noteDao: NoteDao) {


    fun insertNote(note: Note) {
        Executors.newSingleThreadExecutor().execute {
//            val note = Note()
            noteDao.insert(note)
        }
    }

    fun getNotes() = noteDao.getNotes()

    fun getNote(noteId: Long) = noteDao.getNote(noteId)

//    suspend fun getNoteObject(noteId: Long):Note{
//        return noteDao.getNoteObject(noteId)
//    }


    // doAsync

    fun getNoteDataAsync(noteId: Long): Deferred<String> = GlobalScope.async(IO)  {
        return@async noteDao.getNoteObject(noteId).note
    }


    fun getNoteData(noteId: Long, callback: (String) -> Unit)  {

        GlobalScope.launch(Dispatchers.Main) {
            var noteData = async(IO){
                noteDao.getNoteObject(noteId).note
            }.await()
            callback(noteData)
        }




//        suspend {  } launch {
            //Execute all the lon running tasks here
//            val s: String = makeNetworkCall()
//            uiThread {
//                //Update the UI thread here
//                alert("Downloaded data is $s", "Hi I'm an alert") {
//                    yesButton { toast("Yay !") }
//                    noButton { toast(":( !") }
//                }.show()
//            }




    }

//    fun loadNoteData(noteId: Long, callback: LoadNoteDataCallback):Note{
////        return noteDao.getNoteObject(noteId)
//
//    }

//    fun getNoteData(noteId: Long) = noteDao.getNoteData(noteId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDao) =
                instance ?: synchronized(this) {
                    instance ?: NoteRepository(noteDao).also { instance = it }
                }
    }

    interface LoadNoteDataCallback {
        fun loadNoteDataCallback(noteData: String)
    }
}

//suspend fun helo(){
//    GlobalScope.launch {
//
//    }
//}
