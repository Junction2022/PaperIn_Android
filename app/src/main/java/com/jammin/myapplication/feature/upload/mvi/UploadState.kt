package com.jammin.myapplication.feature.upload.mvi

data class UploadState(
    val isLoading: Boolean = false,
    val titleValue: String = "",
    val keyWordValue: String = "",
    val fileUpload: Boolean = false
)
