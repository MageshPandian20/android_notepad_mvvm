package com.example.esamohammed.mvvm.util

import android.util.Log

object Log {
    fun d(message:String) {
        Log.d("Debug",message)
    }
    fun e(message:String){
        Log.e("Error",message)
    }
    fun i(message:String){
        Log.i("info",message)
    }

}