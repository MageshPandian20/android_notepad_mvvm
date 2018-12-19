package com.example.esamohammed.mvvm.repository.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.esamohammed.mvvm.repository.dto.common.NotesEntity

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NotesEntity>


    @Insert
    fun insertAll(vararg notes: NotesEntity)

    @Query("DELETE FROM notes")
    fun nukeTable()

}