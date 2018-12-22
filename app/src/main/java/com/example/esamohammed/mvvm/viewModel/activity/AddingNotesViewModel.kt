package com.example.esamohammed.mvvm.viewModel.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.repository.NotesRepository
import com.example.esamohammed.mvvm.repository.dto.request.FileCreateRequest
import com.example.esamohammed.mvvm.util.Constants
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_TOAST
import com.example.esamohammed.mvvm.viewModel.BaseViewModel
import com.example.esamohammed.notepadmvvm.R
import io.reactivex.android.schedulers.AndroidSchedulers

class AddingNotesViewModel : BaseViewModel() {
    val eventLiveData = MutableLiveData<Pair<Int,String>>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    @SuppressLint("CheckResult")
    fun loadNotesEntity(notesName: String, notesContent: String) {
        basicEventLiveData.postValue(Constants.UIEventFlags.SHOW_PROGRESS_BAR)
        NotesRepository().createNotes(FileCreateRequest(notesName, notesContent))
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                eventLiveData.postValue(Pair(Constants.NavigationFlag.NAVIGATE_TO_HOMEACTIVITY,""))
                basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)

            }) {
                basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)
                eventLiveData.postValue(Pair(SHOW_TOAST, mContext.getString(R.string.alert_common )))
        }
    }
}