package com.jammin.myapplication.data.model.response.thesis

data class ThesisX(
    val author: String,
    val comments: List<String>,
    val downloadCount: Int,
    val exportCount: Int,
    val `file`: String,
    val id: String,
    val language: String,
    val pageCount: Int,
    val title: String,
    val topic: String,
    val viewCount: Int
)