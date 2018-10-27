package com.tomberghuis.personalnotes.viewmodels


import android.util.Log
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tomberghuis.personalnotes.R
import com.tomberghuis.personalnotes.data.Note
import com.tomberghuis.personalnotes.data.NoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditNoteViewModel(
        private val noteRepository: NoteRepository,
        private val noteId: Long
) : ViewModel() {

    var note: MutableLiveData<String> = MutableLiveData<String>()

    init{

        if(noteId!=-1L) {

            GlobalScope.launch {
                note.postValue(noteRepository.getNoteDataAsync(noteId).await())
            }

//            noteRepository.getNoteData(noteId){
//                noteData -> note.setValue(noteData)
//            }
            //noteRepository.loadNoteData(noteId,this)
        }

    }

//    fun loadNoteDataCallback(noteData: String){
//        note.value = noteData
//    }


    fun loadTmpNote(et: EditText){
//        et.setText("hellp")

        noteRepository.getNoteData(noteId){
            noteData -> et.setText(noteData)
        }


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
