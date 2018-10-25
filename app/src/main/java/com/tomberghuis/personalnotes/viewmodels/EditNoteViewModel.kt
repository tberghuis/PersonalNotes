package com.tomberghuis.personalnotes.viewmodels


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tomberghuis.personalnotes.R
import com.tomberghuis.personalnotes.data.Note
import com.tomberghuis.personalnotes.data.NoteRepository

class EditNoteViewModel(
        private val noteRepository: NoteRepository,
        private val noteId: Long
) : ViewModel() {

    var note: MutableLiveData<String> = MutableLiveData<String>().apply{
        var initialNote = ""
        // new notes have noteId = -1L
//        if(noteId!=-1L) initialNote = noteRepository.getNoteData(noteId)
        if(noteId!=-1L) initialNote = noteRepository.getNote(noteId).value?.note ?: ""
        postValue(initialNote)
    }

init{
    // TODO how the hell am i getting -1
    Log.d("aaa",""+noteId)
}


    fun saveNote() {

        val note = Note(note.value!!)

        // TODO rewrite

        noteRepository.insertNote(note)

//        val task = Task(title.get(), description.get())
//        if (task.isEmpty) {
//            showSnackbarMessage(R.string.empty_task_message)
//            return
//        }
//        if (isNewTask) {
//            createTask(task)
//        } else {
//            taskId?.let {
//                updateTask(Task(title.get(), description.get(), it)
//                        .apply { isCompleted = taskCompleted })
//            }
//        }
    }

    private fun createNote(newNote: Note) {
//        tasksRepository.saveTask(newTask)
//        taskUpdatedEvent.call()

//        launch {
//
//        }
    }

}
