package com.exemple.jetnoteapp.repository

import com.exemple.jetnoteapp.data.NoteDatabaseDao
import com.exemple.jetnoteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository
@Inject constructor(private val noteDatabaseDao : NoteDatabaseDao) {
    suspend fun addNote(note: Note) {
        noteDatabaseDao.insert(note)
    }

    suspend fun updateNote(note: Note) {
        noteDatabaseDao.update(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDatabaseDao.deleteNoteById(note.id.toString())
    }

    suspend fun deleteAll() {
        noteDatabaseDao.deleteAll()
    }

    suspend fun getNote(note: Note): Note {
        return noteDatabaseDao.getNoteById(note.id.toString())
    }

    fun getAllNotes(): Flow<List<Note>> {
        return noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO).conflate()
    }

}