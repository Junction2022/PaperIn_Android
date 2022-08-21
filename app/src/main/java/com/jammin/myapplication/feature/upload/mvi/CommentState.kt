package com.jammin.myapplication.feature.upload.mvi

data class CommentState(
    val isLoading: Boolean = false,
    val comment: String = ""
)
