package com.example.esamohammed.mvvm.viewModel.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.repository.NotesRepository
import com.example.esamohammed.mvvm.repository.dto.request.LoginRequest
import com.example.esamohammed.mvvm.repository.dto.response.LoginResponse
import com.example.esamohammed.mvvm.util.Constants
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_HOMEACTIVITY
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_SIGNUPACTIVITY
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_PROGRESS_BAR
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_TOAST
import com.example.esamohammed.mvvm.viewModel.BaseViewModel
import com.example.esamohammed.notepadmvvm.R
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginViewModel : BaseViewModel() {

    var loginResposeData = MutableLiveData<LoginResponse>()
    var eventLiveData = MutableLiveData<Pair<Int, String>>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
        if (sharedPreferences?.isLoggedIn!!)
            eventLiveData.value = Pair(NAVIGATE_TO_HOMEACTIVITY, "")
    }

    @SuppressLint("CheckResult")
    fun setData(userId: String, password: String) {
        basicEventLiveData.postValue(SHOW_PROGRESS_BAR)
        if (userId.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_userName_empty ))
        if (password.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST,  mContext.getString(R.string.alert_password_required ))

        NotesRepository().login(LoginRequest(userId, password)).observeOn(AndroidSchedulers.mainThread()).subscribe({
            loginResposeData.value = it
            sharedPreferences?.authToken = it.result.userToken!!
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)

        }) {
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_common ))
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)
        }
    }

    fun notExistingUser() {
        eventLiveData.value = Pair(NAVIGATE_TO_SIGNUPACTIVITY, "")
    }
}