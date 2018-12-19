package com.example.esamohammed.mvvm.repository.dto.common

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "notes")
data class NotesEntity(
    @ColumnInfo(name = "notesName")
    @field:Json(name = "notesName")
    var notesName: String?,
    @ColumnInfo(name = "notesContent")
    @field:Json(name = "content")
    var notesContent: String?,
    @PrimaryKey(autoGenerate = true) var notesId: Int? = null
)