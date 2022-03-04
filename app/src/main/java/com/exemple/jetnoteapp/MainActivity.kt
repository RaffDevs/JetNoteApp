package com.exemple.jetnoteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.exemple.jetnoteapp.data.NoteDataSource
import com.exemple.jetnoteapp.screen.NoteScreen
import com.exemple.jetnoteapp.screen.NoteViewModel
import com.exemple.jetnoteapp.ui.theme.JetNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NoteScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetNoteAppTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteAppTheme {
    }
}