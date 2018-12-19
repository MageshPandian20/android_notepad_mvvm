package com.example.esamohammed.mvvm.repository.webservice

import com.example.esamohammed.mvvm.repository.dto.request.*
import com.example.esamohammed.mvvm.repository.dto.response.ListNotesResponse
import com.example.esamohammed.mvvm.repository.dto.response.LoginResponse
import com.example.esamohammed.mvvm.repository.dto.response.StringResponse
import retrofit2.Call
import retrofit2.http.*
import io.reactivex.Observable


interface ApiInterface {
    @PUT("userLogin")
    fun loginAsUser(@Body request: LoginRequest): Observable<LoginResponse>

    @POST("signupUser")
    fun signUp(@Body request: SignUpRequest): Observable<StringResponse>

    @GET("listFiles")
    fun getNotesList(): Observable<ListNotesResponse>

    @PUT("updateFile")
    fun editFile(@Body request: FileUpdateRequest): Observable<StringResponse>

    @POST("createFile")
    fun createFile(@Body request: FileCreateRequest): Observable<StringResponse>

    @DELETE("deleteFile")
    fun deleteFile(@Body request: DeleteFileRequest): Observable<StringResponse>

}