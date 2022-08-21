package com.jammin.myapplication.utils

import com.jammin.myapplication.core.component.CommentModel
import com.jammin.myapplication.data.model.response.comment.Comment

fun Comment.mapToModel(): CommentModel {
    return CommentModel(
        comment = text,
        likeNum = like,
        disLikeNum = dislike,
        agoTime = user.nickname,
    )
}