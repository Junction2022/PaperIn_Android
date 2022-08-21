package com.jammin.myapplication.data.network

import com.jammin.myapplication.data.model.request.thesis.CreateThesisRequest
import com.jammin.myapplication.data.model.response.thesis.GetAllThesisResponse
import com.jammin.myapplication.data.model.response.thesis.ThesisResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ThesisAPI {

    @GET("thesis")
    suspend fun getAllThesis(): GetAllThesisResponse

    @GET("thesis/{thesis_id}")
    suspend fun getThesis(@Path("thesis_id") thesisId: String): ThesisResponse

    @POST("thesis")
    suspend fun createThesis(
        @Body createThesisRequest: CreateThesisRequest
    ): ThesisResponse

    @Multipart
    @POST("upload")
    suspend fun upload(
        @Part file: MultipartBody,
    ): String
}