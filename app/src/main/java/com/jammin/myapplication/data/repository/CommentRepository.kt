package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.data.model.response.comment.CreateCommentResponse

interface CommentRepository {
    suspend fun createComment(createCommentRequest: CreateCommentRequest): Result<CreateCommentResponse>

    suspend fun likeComment(commentId: String)

    suspend fun disLikeComment(commentId: String)
}
