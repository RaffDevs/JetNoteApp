package com.exemple.jetnoteapp.model

import java.time.LocalDateTime
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val note: String,
    val entryData: LocalDateTime = LocalDateTime.now()
)
