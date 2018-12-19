package com.example.esamohammed.mvvm.repository

import android.accounts.AuthenticatorException
import com.example.esamohammed.mvvm.common.Constants.HttpErrorMessage.Companion.FORBIDDEN
import com.example.esamohammed.mvvm.common.Constants.HttpErrorMessage.Companion.INTERNAL_SERVER_ERROR
import com.example.esamohammed.mvvm.common.Constants.HttpErrorMessage.Companion.TIMEOUT
import com.example.esamohammed.mvvm.common.Constants.HttpErrorMessage.Companion.UNAUTHORIZED
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.BAD_REQUEST_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.INTERNAL_SERVER_ERROR_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.TIMEOUT_CODE
import com.example.esamohammed.mvvm.common.Constants.InternalHttpCode.Companion.UNAUTHORIZED_CODE
import com.example.esamohammed.mvvm.di.AppController
import com.example.esamohammed.mvvm.repository.dto.response.BaseResponse
import com.example.esamohammed.mvvm.repository.dto.response.ErrorResponse
import com.example.esamohammed.mvvm.util.CustomException
import com.example.esamohammed.mvvm.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException
import java.net.SocketTimeoutException

abstract class CallbackWrapper<T : BaseResponse> : DisposableObserver<T>() {

    private val injectorHelper: AppController = AppController()
    private val tag = javaClass.simpleName
    private val errorCode =0
    private val errorMessage = "something went wrong"

    override fun onComplete() {

    }

    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
        Log.d( "onError: " + e.toString())
        if (e is HttpException) {
            if (e.code()== UNAUTHORIZED_CODE){
                failure(CustomException(UNAUTHORIZED_CODE, UNAUTHORIZED))
            }else{
                failure(parseError(e))
            }
        } else if (e is SocketTimeoutException) {
            failure(CustomException(TIMEOUT_CODE, TIMEOUT))
        } else if (e is IOException) {
            failure(CustomException(BAD_REQUEST_CODE, FORBIDDEN))
        } else if (e is AuthenticatorException) {
            failure(CustomException(UNAUTHORIZED_CODE, UNAUTHORIZED))
        } else {
            failure(CustomException(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR))
        }
    }

    private fun parseError(throwable: HttpException?): CustomException {
        val converter: Converter<ResponseBody, ErrorResponse> = injectorHelper.apiClient.retrofit.responseBodyConverter(ErrorResponse::class.java, emptyArray())
        Log.d("Message: "+converter.convert(throwable?.response()?.errorBody()!!).message+" ---- "+"Code: "+throwable.response()!!.code())
        return CustomException(errorCode,errorMessage)
    }


    abstract fun success(response: T)

    abstract fun failure(e: Throwable)
}