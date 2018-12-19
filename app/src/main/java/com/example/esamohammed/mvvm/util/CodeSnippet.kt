package com.example.esamohammed.mvvm.util

import android.content.Context
import com.example.esamohammed.mvvm.di.AppController

class CodeSnippet(context: Context) {

    init {
        AppController.appComponent.inject(this)
    }
}