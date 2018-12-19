package com.example.esamohammed.mvvm.viewModel.activity

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.adapter.NotesAdapter
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_ADDNOTES
import com.example.esamohammed.mvvm.viewModel.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val listEventLiveData = MutableLiveData<Pair<NotesAdapter,Int>>()
    val navigationEventLiveData = MutableLiveData<Pair<Bundle,Int>>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    fun navigateToAddNotes() {
           navigationEventLiveData.postValue(Pair(Bundle(),NAVIGATE_TO_ADDNOTES))
    }


}