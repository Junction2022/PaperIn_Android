package com.jammin.myapplication.feature.upload.mvi

sealed class UploadSideEffect {
    object UploadSuccess: UploadSideEffect()
    object UploadFailed: UploadSideEffect()
}
