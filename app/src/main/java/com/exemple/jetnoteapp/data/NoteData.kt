package com.exemple.jetnoteapp.data

import com.exemple.jetnoteapp.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", note = "We went on a vacation by the lake"),
            Note(title = "Android Compose", note = "Working on Android Compose course today"),
            Note(title = "Keep at it...", note = "Sometimes things just happen"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family today"),
            Note(title = "A movie day", note = "Watching a movie with family")
        )
    }
}