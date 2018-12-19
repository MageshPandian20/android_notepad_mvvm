package com.example.esamohammed.mvvm.di

import android.app.Application
import com.example.esamohammed.mvvm.repository.webservice.ApiClient
import javax.inject.Inject


class AppController : Application() {

    @Inject
    lateinit var apiClient: ApiClient

    companion object {
        lateinit var appController: AppController
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appController = this
        appComponent =  DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
    }
}