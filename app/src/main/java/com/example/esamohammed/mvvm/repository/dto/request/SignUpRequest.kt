package com.example.esamohammed.mvvm.repository.dto.request

import com.squareup.moshi.Json


data class SignUpRequest(
    @field:Json(name = "userId") var mailId: String? = null,
    var userName: String? = null,
    var password: String? = null,
    var phoneNumber: String? = null
)