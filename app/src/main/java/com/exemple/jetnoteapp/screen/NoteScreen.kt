package com.exemple.jetnoteapp.screen

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exemple.jetnoteapp.R
import com.exemple.jetnoteapp.components.NoteButton
import com.exemple.jetnoteapp.components.NoteTextField
import com.exemple.jetnoteapp.components.NotesLazyColumn
import com.exemple.jetnoteapp.model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(noteViewModel: NoteViewModel = viewModel()) {
    val context = LocalContext.current

    val title = remember {
        mutableStateOf("")
    }

    val note = remember {
        mutableStateOf("")
    }

    val notes = noteViewModel.getAllNotes()


    Scaffold(
        topBar = {
            MyAppBar()
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                NoteTextField(
                    text = title.value,
                    onTextChange = { newText ->
                        if (newText.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) title.value = newText

                    },
                    label = "Title",
                    imeAction = ImeAction.Next
                )

                NoteTextField(
                    text = note.value,
                    onTextChange = { newText ->
                        if (newText.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) note.value = newText
                    },
                    label = "Note",
                    imeAction = ImeAction.Done
                )

                NoteButton(
                    text = "Save",
                    onClick = {
                        if (title.value.isNotEmpty() && note.value.isNotEmpty()) {
                            noteViewModel.addNote(
                                Note(
                                    title = title.value,
                                    note = note.value
                                )
                            )

                            title.value = ""
                            note.value = ""

                            Toast.makeText(
                                context,
                                "Note created!",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    },
                    modifier = Modifier
                        .padding(vertical = 18.dp)
                )
                Divider(modifier = Modifier.padding(10.dp))
                NotesLazyColumn(
                    notes = notes,
                    onNoteClicked = { note ->
                       noteViewModel.removeNote(note)
                    }

                )
            }


        }
    }

}

@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Notification Icon"
            )
        },
        backgroundColor = Color.LightGray
    ) 
}