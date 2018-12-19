package com.example.esamohammed.mvvm.viewModel.activity

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.viewModel.BaseViewModel

class SignUpViewModel : BaseViewModel() {

    var eventLiveData = MutableLiveData<Int>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    fun signup(userName: String, mailId: String, phoneNumber: String, password: String, confirmation: String) {
    }
}

