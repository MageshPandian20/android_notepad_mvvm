package com.example.esamohammed.mvvm.repository.webservice

import android.content.Context
import com.example.esamohammed.mvvm.common.SharedPrefManager
import com.example.esamohammed.mvvm.util.CodeSnippet
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient(context: Context, private val sharedPrefManager: SharedPrefManager) {
    private val BASE_URL: String = " https://protected-plateau-92327.herokuapp.com/api/"
    private val AUTHORIZATION: String = "Authorization"
    val retrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)  // <-- this is the important line!
             httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
        .header(AUTHORIZATION, sharedPrefManager.authToken)
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create()) /*Use can mention your desired parser over here.!*/
            .build()
    }

    fun apiInterface() = retrofit.create(ApiInterface::class.java)

}


