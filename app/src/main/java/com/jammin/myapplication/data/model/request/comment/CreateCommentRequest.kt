package com.jammin.myapplication.data.model.request.comment

data class CreateCommentRequest(
    val text: String,
    val thesisId: String
)
