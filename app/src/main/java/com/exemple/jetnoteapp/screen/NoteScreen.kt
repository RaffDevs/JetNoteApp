package com.exemple.jetnoteapp.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.exemple.jetnoteapp.R
import com.exemple.jetnoteapp.components.NoteButton
import com.exemple.jetnoteapp.components.NoteTextField
import com.exemple.jetnoteapp.model.Note

@Composable
fun NoteScreen(
    notes: List<Note>
) {
    val title = remember {
        mutableStateOf("")
    }

    val note = remember {
        mutableStateOf("")
    }
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
                            title.value = ""
                            note.value = ""
                        }
                    },
                    modifier = Modifier
                        .padding(vertical = 18.dp)
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
                contentDescription = "Icon"
            )
        },
        backgroundColor = Color.LightGray
    ) 
}