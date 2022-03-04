package com.exemple.jetnoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "title")
    val title: String,
    val note: String,
    val entryData: LocalDateTime = LocalDateTime.now()
)
