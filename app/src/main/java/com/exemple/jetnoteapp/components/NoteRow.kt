package com.exemple.jetnoteapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.exemple.jetnoteapp.model.Note
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onClicked: (Note) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        backgroundColor = Color(0xFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    onClicked(note)
                }
                .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = note.note,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text =  note.entryData.format(
                    DateTimeFormatter.ofPattern("EEE d MMM")
                ),
                style = MaterialTheme.typography.caption

            )
        }
    }
}