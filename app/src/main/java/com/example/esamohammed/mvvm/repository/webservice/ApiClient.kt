package com.example.esamohammed.mvvm.repository.webservice

import android.content.Context
import com.example.esamohammed.mvvm.common.SharedPrefManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Singleton
class ApiClient(val context: Context, provideSharedPrefManager: SharedPrefManager) {
    val retrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        retrofit = Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl("")
            .addConverterFactory(
                MoshiConverterFactory
                    .create(
                        Moshi
                            .Builder()
                            .add(KotlinJsonAdapterFactory())
                            .build()
                    )
            )
            .build()
    }

    fun apiInterface() = retrofit.create(ApiInterface::class.java)
}