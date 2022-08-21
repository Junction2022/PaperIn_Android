package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.data.model.response.comment.CreateCommentResponse
import com.jammin.myapplication.data.network.CommentAPI
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val api: CommentAPI
) : CommentRepository {
    override suspend fun createComment(createCommentRequest: CreateCommentRequest): Result<CreateCommentResponse> =
        kotlin.runCatching {
            api.createComment(createCommentRequest)
        }

    override suspend fun likeComment(commentId: String) {
        api.likeComment(commentId)
    }

    override suspend fun disLikeComment(commentId: String)  {
        api.disLikeComment(commentId)
    }
}