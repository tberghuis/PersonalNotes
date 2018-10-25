package com.tomberghuis.personalnotes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tomberghuis.personalnotes.InboxFragmentDirections
import com.tomberghuis.personalnotes.data.Note
import com.tomberghuis.personalnotes.databinding.ListItemNoteBinding

class NoteAdapter : ListAdapter<Note, NoteAdapter.ViewHolder>(NoteDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = getItem(position)
        holder.apply {
            bind(createOnClickListener(note.noteId), note)
            itemView.tag = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(noteId: Long): View.OnClickListener {
        return View.OnClickListener {
            val direction = InboxFragmentDirections.actionEditNote(noteId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemNoteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Note) {
            binding.apply {
                clickListener = listener
                note = item
                executePendingBindings()
            }
        }
    }
}




class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.noteId == newItem.noteId
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}

