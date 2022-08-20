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
    fun signUp(
        @Body signUpRequest: SignUpRequest
    ): SignUpResponse

    @POST("auth/login")
    fun signIn(
        @Body signInRequest: SignInRequest
    ): SignInResponse

    @POST("auth/refresh-tokens")
    fun refresh(
        @Body refreshToken: String
    ): RefreshResponse
}
