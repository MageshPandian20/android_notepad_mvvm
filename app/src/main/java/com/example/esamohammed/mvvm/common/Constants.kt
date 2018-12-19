package com.example.esamohammed.mvvm.common

interface Constants {
    interface Common

    interface InternalHttpCode {
        companion object {
            val SUCCESS_CODE = 200
            val FAILURE_CODE = 404
            val BAD_REQUEST_CODE = 400
            val UNAUTHORIZED_CODE = 401
            val INTERNAL_SERVER_ERROR_CODE = 500
            val TIMEOUT_CODE = 504
        }
    }



    interface HttpErrorMessage {
        companion object {
            val INTERNAL_SERVER_ERROR = "Our server is under maintenance. We will resolve shortly!"
            val FORBIDDEN = "Seems like you haven't permitted to do this operation!"
            val TIMEOUT = "Unable to connect to server. Please try after sometime"
            val UNAUTHORIZED = "UnAuthorized"
        }

    }

}