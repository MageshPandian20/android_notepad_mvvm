package com.example.esamohammed.mvvm.repository.dto.common

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey var userId: String?=null,
    @ColumnInfo(name = "userName") var userName: String?,
    @ColumnInfo(name = "userPhone") var userPhoneNumber: String?,
    @ColumnInfo(name = "userEmail") var userMail: String?,
    @ColumnInfo(name = "userPassword") var userPassword: String?
)