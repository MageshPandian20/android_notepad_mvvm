package com.example.esamohammed.mvvm.viewModel.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.esamohammed.mvvm.repository.NotesRepository
import com.example.esamohammed.mvvm.repository.dto.request.SignUpRequest
import com.example.esamohammed.mvvm.repository.dto.response.StringResponse
import com.example.esamohammed.mvvm.util.Constants
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_TOAST
import com.example.esamohammed.mvvm.viewModel.BaseViewModel
import com.example.esamohammed.notepadmvvm.R
import io.reactivex.android.schedulers.AndroidSchedulers

class SignUpViewModel : BaseViewModel() {

    var eventLiveData = MutableLiveData<Pair<Int, String>>()
    var signUpResponseData = MutableLiveData<StringResponse>()

    override fun onViewCreated(extras: Bundle?) {
    }

    override fun onCreate(bundle: Bundle?) {
    }

    @SuppressLint("CheckResult")
    fun signup(userName: String, mailId: String, phoneNumber: String, password: String, confirmation: String) {
        basicEventLiveData.postValue(Constants.UIEventFlags.SHOW_PROGRESS_BAR)
        if (userName.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_userName_empty))
        if (mailId.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_mail_required))
        if (phoneNumber.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_password_required))
        if (password.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_password_required))
        if (confirmation.isEmpty())
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_password_required))
        if (!password.equals(confirmation))
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_password_mismatch))

        val request = SignUpRequest(mailId, userName, password, phoneNumber)

        NotesRepository().signup(request).observeOn(AndroidSchedulers.mainThread()).subscribe({
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)
            signUpResponseData.value = it
        }) {
            basicEventLiveData.postValue(Constants.UIEventFlags.DISMISS_PROGRESS_BAR)
            eventLiveData.value = Pair(SHOW_TOAST, mContext.getString(R.string.alert_common))
        }

    }
}

