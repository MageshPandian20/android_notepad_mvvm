package com.example.esamohammed.mvvm.repository

import com.example.esamohammed.mvvm.repository.dto.request.*

class NotesRepository:BaseRepository() {

    fun login(request: LoginRequest) = enqueue(apiClient.apiInterface().loginAsUser(request))
    fun signup(request: SignUpRequest) = enqueue(apiClient.apiInterface().signUp(request))

    fun createNotes(request: FileCreateRequest) = enqueue(apiClient.apiInterface().createFile(request))
    fun editNotes(request: FileUpdateRequest) = enqueue(apiClient.apiInterface().editFile(request))
    fun deleteNotes(request: DeleteFileRequest) = enqueue(apiClient.apiInterface().deleteFile(request))

    fun notesList() = enqueue(apiClient.apiInterface().getNotesList())

}
