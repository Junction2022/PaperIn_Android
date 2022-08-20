package com.jammin.myapplication.data.model.response.thesis

data class Thesis(
    val comments: List<Comment>,
    val title: String,
    val hash: String,
    val language: String,
    val topic: String,
    val pageCount: String,
    val author: String,
    val id: String
)
