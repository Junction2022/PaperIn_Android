package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.data.model.request.thesis.CreateThesisRequest
import com.jammin.myapplication.data.model.response.comment.CreateCommentResponse
import com.jammin.myapplication.data.model.response.thesis.GetAllThesisResponse
import com.jammin.myapplication.data.model.response.thesis.ThesisResponse
import okhttp3.MultipartBody

interface CommentRepository {
    suspend fun createComment(createCommentRequest: CreateCommentRequest): Result<CreateCommentResponse>

    suspend fun likeComment(commentId: String)

    suspend fun disLikeComment(commentId: String)
}
