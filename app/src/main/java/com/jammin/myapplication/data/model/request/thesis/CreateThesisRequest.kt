package com.jammin.myapplication.data.model.request.thesis

data class CreateThesisRequest(
    val title: String,
    val file: String,
    val language: String,
    val topic: String,
    val pageCount: String,
    val author: String
)