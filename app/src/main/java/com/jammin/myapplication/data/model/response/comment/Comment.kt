package com.jammin.myapplication.data.model.response.comment

import com.jammin.myapplication.data.model.response.user.User

data class Comment(
    val like: Int,
    val dislike: Int,
    val text: String,
    val user: User,
    val thesis: String,
    val id: String
)