package com.example.esamohammed.mvvm.repository.listener

import com.example.esamohammed.mvvm.util.CustomException


interface IBaseModelListener<T> {

    fun onSuccessfulApi(taskId: Long, response: T)

    fun onFailureApi(taskId: Long, e: CustomException)
}