package com.example.esamohammed.mvvm.viewModel.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.adapter.NotesAdapter
import com.example.esamohammed.mvvm.repository.NotesRepository
import com.example.esamohammed.mvvm.repository.dto.common.NotesEntity
import com.example.esamohammed.mvvm.repository.dto.response.ListNotesResponse
import com.example.esamohammed.mvvm.util.Constants
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_ADDNOTES
import com.example.esamohammed.mvvm.viewModel.BaseViewModel
import com.example.esamohammed.notepadmvvm.R
import io.reactivex.android.schedulers.AndroidSchedulers

class HomeViewModel : BaseViewModel() {

    val listEventLiveData = MutableLiveData<Pair<NotesAdapter, Int>>()
    val eventLiveData = MutableLiveData<Pair<Int, String>>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()
        basicEventLiveData.postValue(Constants.UIEventFlags.SHOW_PROGRESS_BAR)

        NotesRepository().notesList().observeOn(AndroidSchedulers.mainThread()).subscribe({
            listEventLiveData.postValue(
                Pair(
                    NotesAdapter(it.result as ArrayList<NotesEntity>),
                    Constants.EventFlags.REFRESH_NOTESLIST
                )
            )
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)

        }) {
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)
            eventLiveData.value = Pair(Constants.UIEventFlags.SHOW_TOAST, mContext.getString(R.string.alert_common))
        }
    }

    fun navigateToAddNotes() {
        eventLiveData.postValue(Pair(NAVIGATE_TO_ADDNOTES, ""))
    }


}