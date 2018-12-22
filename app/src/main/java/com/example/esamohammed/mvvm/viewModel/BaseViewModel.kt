package com.example.esamohammed.mvvm.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.esamohammed.mvvm.common.SharedPrefManager
import com.example.esamohammed.mvvm.repository.database.AppDatabase

abstract class BaseViewModel : ViewModel() {

    open var database: AppDatabase? = null
    @SuppressLint("StaticFieldLeak")
    open lateinit var mContext: Context
    open var sharedPreferences: SharedPrefManager? = null
    open var basicEventLiveData = MutableLiveData<Int>()

    abstract fun onViewCreated(extras: Bundle?)

    abstract fun onCreate(bundle: Bundle?)

    open fun onPause() {}

    open fun onResume() {}

    open fun startActivityForResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    fun initContext(applicationContext: Context?) {
        sharedPreferences= SharedPrefManager(applicationContext!!)
        database = AppDatabase.getInstance(applicationContext)
        mContext=applicationContext

    }

   }