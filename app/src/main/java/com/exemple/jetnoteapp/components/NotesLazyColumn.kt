package com.exemple.jetnoteapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.exemple.jetnoteapp.model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesLazyColumn(
    notes: List<Note>,
    onNoteClicked: (Note) -> Unit
) {
    LazyColumn {
        items(notes) { note ->
            NoteRow(note = note, onClicked = {
                onNoteClicked(it)
            })
        }
    }
}