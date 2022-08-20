package com.jammin.myapplication.data.network

import com.jammin.myapplication.data.model.request.auth.SignInRequest
import com.jammin.myapplication.data.model.request.auth.SignUpRequest
import com.jammin.myapplication.data.model.response.auth.RefreshResponse
import com.jammin.myapplication.data.model.response.auth.SignInResponse
import com.jammin.myapplication.data.model.response.auth.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("auth/register")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): SignUpResponse

    @POST("auth/login")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): SignInResponse

    @POST("auth/refresh-tokens")
    suspend fun refresh(
        @Body refreshToken: String
    ): RefreshResponse
}
