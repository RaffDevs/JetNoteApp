package com.exemple.jetnoteapp.data

import androidx.room.*
import com.exemple.jetnoteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query(value = "SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<Note>>

    @Query(value = "SELECT * FROM notes_table WHERE id = :id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query(value = "DELETE FROM notes_table")
    suspend fun deleteAll()

    @Query(value = "DELETE FROM notes_table WHERE id = :id")
    suspend fun deleteNoteById(id: String)

}
