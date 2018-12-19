package com.example.esamohammed.mvvm.util

import com.example.esamohammed.mvvm.repository.dto.response.BaseResponse


class CustomException : Exception {

    var code: Int = 0

    var exception: String? = null

    constructor(code: Int, exception: String) {
        this.code = code
        this.exception = exception
    }

    constructor(code: Int, throwable: Throwable) {
        this.code = code
        this.exception = throwable.message
    }

    constructor(code: Int, response: BaseResponse) {
        this.code = code
        this.exception = response.error
    }

    constructor() {}
}