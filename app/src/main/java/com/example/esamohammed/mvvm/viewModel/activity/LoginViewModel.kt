package com.example.esamohammed.mvvm.viewModel.activity

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.repository.dto.request.LoginRequest
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_HOMEACTIVITY
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_SIGNUPACTIVITY
import com.example.esamohammed.mvvm.viewModel.BaseViewModel

class LoginViewModel : BaseViewModel() {

    var loginLiveData = MutableLiveData<LoginRequest>()
    var eventLiveData = MutableLiveData<Int>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
        if (sharedPreferences?.isLoggedIn!!)
            eventLiveData.value = NAVIGATE_TO_HOMEACTIVITY
    }

    fun setData(userId: String, password: String) {
      }

    fun notExistingUser() {
        eventLiveData.value = NAVIGATE_TO_SIGNUPACTIVITY
    }
}