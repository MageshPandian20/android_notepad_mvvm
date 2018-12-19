package com.example.esamohammed.mvvm.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.esamohammed.mvvm.di.AppController
import com.example.esamohammed.mvvm.repository.database.dao.NotesDao
import com.example.esamohammed.mvvm.repository.dto.common.NotesEntity

@Database(entities = arrayOf(NotesEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    init {
        AppController.appComponent.inject(this)
    }

    abstract fun notesDao(): NotesDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "notesDb")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}
