package com.example.esamohammed.mvvm.repository.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.esamohammed.mvvm.repository.dto.common.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllNotes(): List<UserEntity>


    @Insert
    fun insertAll(vararg notes: UserEntity)

    @Query("DELETE FROM user")
    fun nukeTable()

}