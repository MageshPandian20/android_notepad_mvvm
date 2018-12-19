package com.example.esamohammed.mvvm.common

import android.content.Context
import com.example.esamohammed.mvvm.util.Constants.PreferenceKeys.Companion.AUTH_TOKEN
import com.example.esamohammed.mvvm.util.Constants.PreferenceKeys.Companion.IS_LOGGEDIN


class SharedPrefManager(private val context: Context) {

    var authToken: String
        get() = SharedPref.instance.getStringValue(context, AUTH_TOKEN)!!
        set(authToken) = SharedPref.instance.setSharedValue(
            context,
            AUTH_TOKEN,
            authToken
        )


    var isLoggedIn: Boolean
        get() = SharedPref.instance.getBooleanValue(context, IS_LOGGEDIN)!!
        set(authToken) = SharedPref.instance.setSharedValue(
            context,
            IS_LOGGEDIN,
            authToken
        )




}
