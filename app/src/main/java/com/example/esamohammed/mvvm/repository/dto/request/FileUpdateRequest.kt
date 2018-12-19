package com.example.esamohammed.mvvm.repository.dto.request

data class FileUpdateRequest(var fileId:String?=null,
                             var name:String?=null,
                             var noteContent:String?=null)