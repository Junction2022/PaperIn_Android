package com.jammin.myapplication.data.network

import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.data.model.response.comment.CreateCommentResponse
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentAPI {

    @POST("comment")
    suspend fun createComment(
        @Body createCommentRequest: CreateCommentRequest
    ): CreateCommentResponse

    @PATCH("/comment/like/{comment_id}")
    suspend fun likeComment(
        @Path("comment_id") commentId: String
    )

    @PATCH("/comment/dislike/{comment_id}")
    suspend fun disLikeComment(
        @Path("comment_id") commentId: String
    )
}
