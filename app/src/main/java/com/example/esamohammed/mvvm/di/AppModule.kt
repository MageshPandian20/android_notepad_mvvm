package com.example.esamohammed.mvvm.di

import android.content.Context
import com.example.esamohammed.mvvm.common.SharedPrefManager
import com.example.esamohammed.mvvm.repository.webservice.ApiClient
import com.example.esamohammed.mvvm.util.CodeSnippet
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class AppModule(@ApplicationContext @Named("applicationContext") private val context: Context) {

    @Provides
    fun provideApplicationContext() = context

    @Provides
    fun provideCodeSnippet() = CodeSnippet(context)


    @Provides
    fun provideSharedPrefManager(): SharedPrefManager {
        return SharedPrefManager(context)
    }

    @Provides
    fun provideApiClient(): ApiClient {
        return ApiClient(context, provideSharedPrefManager())
    }
}