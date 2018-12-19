package com.example.esamohammed.mvvm.repository.listener


interface IRepositoryModel {

    fun isInternetConnected(): Boolean

    fun logoutUser()

    fun unAuthorizedUser()

    fun showRetryOption()

    fun showNetworkUnavailable()

    fun dismissProgressbar()
}