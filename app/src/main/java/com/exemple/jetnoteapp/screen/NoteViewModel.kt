package com.exemple.jetnoteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.exemple.jetnoteapp.data.NoteDataSource
import com.exemple.jetnoteapp.model.Note

class NoteViewModel : ViewModel() {
    private val notesList = mutableStateListOf<Note>()

    init {
        notesList.addAll(NoteDataSource().loadNotes())
    }

    fun getAllNotes(): List<Note> {
        return notesList
    }

    fun addNote(note: Note) {
        notesList.add(note)
    }

    fun removeNote(note: Note) {
        notesList.remove(note)
    }
}