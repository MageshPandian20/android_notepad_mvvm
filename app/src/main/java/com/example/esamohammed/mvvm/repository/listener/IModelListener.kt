package com.example.esamohammed.mvvm.repository.listener

import com.example.esamohammed.mvvm.util.CustomException


interface IModelListener<T> {

    fun onSuccessfulApi(taskId: Int, response: T)

    fun onFailureApi(taskId: Int, e: CustomException)
}