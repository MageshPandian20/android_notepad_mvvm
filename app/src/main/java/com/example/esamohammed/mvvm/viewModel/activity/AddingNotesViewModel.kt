package com.example.esamohammed.mvvm.viewModel.activity

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.viewModel.BaseViewModel

class AddingNotesViewModel : BaseViewModel() {
    val listEventLiveData = MutableLiveData<Int>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    fun loadNotesEntity(notesName: String, notesContent: String) {
    }




    /*  fun loadNotesEntity(notesName: String, notesContent: String) {
      val createNotesModel = StringModel(this, createNoteListener)
      createNotesModel.createNotes(CREATENOTES, sharedPreferences!!, FileCreateRequest(notesName, notesContent))
  }
*/

   /* private val createNoteListener = object : IModelListener<StringResponse> {
        override fun onSuccessfulApi(taskId: Long, response: StringResponse) {
            listEventLiveData.postValue(NAVIGATE_TO_HOMEACTIVITY)
        }

        override fun onFailureApi(taskId: Long, e: CustomException) {
        }


    }*/

}