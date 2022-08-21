package com.jammin.myapplication.data.model.response.thesis

import com.jammin.myapplication.data.model.response.comment.Comment

data class Thesis(
    val comments: List<Comment>,
    val title: String,
    val file: String,
    val language: String,
    val topic: String,
    val pageCount: String,
    val author: String,
    val id: String
)
