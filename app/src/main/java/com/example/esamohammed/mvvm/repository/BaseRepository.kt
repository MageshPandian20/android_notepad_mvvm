package com.example.esamohammed.mvvm.repository

import android.content.Context
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.BAD_REQUEST_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.FAILURE_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.INTERNAL_SERVER_ERROR_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.TIMEOUT_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.UNAUTHORIZED_CODE
import com.example.esamohammed.mvvm.di.AppController
import com.example.esamohammed.mvvm.repository.dto.response.BaseResponse
import com.example.esamohammed.mvvm.repository.webservice.ApiClient
import com.example.esamohammed.mvvm.util.CustomException
import com.example.esamohammed.mvvm.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

abstract class BaseRepository {
    @Inject
    lateinit var apiClient: ApiClient

    @Inject
    lateinit var context: Context

    init {
        AppController.appComponent.inject(this)
    }

    protected fun <T : BaseResponse> enqueue(observable: Observable<T>): Observable<T> {

        return Observable.create<T> { emitter: ObservableEmitter<T> ->
            run {
                observable.subscribeOn(Schedulers.newThread())
                    .subscribeWith(object : CallbackWrapper<T>() {
                        override fun success(response: T) {
                            Log.d("Success: " + response.message)
                            emitter.onNext(response)
                        }
                        override fun failure(e: Throwable) {
                             Log.d("failure: " + e.toString())
                            when ((e as CustomException).code) {
                                TIMEOUT_CODE -> {
                                    emitter.onError(e)
                                }
                                BAD_REQUEST_CODE -> {
                                    emitter.onError(Throwable(e.exception))
                                }
                                INTERNAL_SERVER_ERROR_CODE -> {
                                    emitter.onError(Throwable(e.exception))
                                }
                                UNAUTHORIZED_CODE -> {
                                    emitter.onError(e)
                                }
                                FAILURE_CODE -> {
                                    emitter.onError(Throwable(e.exception))
                                }
                                else -> emitter.onError(Throwable(e.exception))
                            }
                        }
                    })
            }
        }

    }


    protected fun <T : BaseResponse> enqueue(callback: Call<T>): Observable<T> {
        return Observable.create<T> {
            callback.enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>?, t: Throwable?) {
                    it.onError(t!!)

                }

                override fun onResponse(call: Call<T>?, response: Response<T>?) {
                    if (response?.body() != null) {
                        it.onNext(response.body()!!)
                    } else {
                        Log.d(CustomException(500, "error").toString())
                    }
                }
            })
        }

    }
}