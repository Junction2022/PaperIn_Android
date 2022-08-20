package com.jammin.myapplication.data.network

import com.jammin.myapplication.data.model.response.SignUpResponse
import com.jammin.myapplication.data.model.request.SignUpRequest
import retrofit2.http.POST

interface ServerAPI {

    @POST("auth/register")
    fun signUp(signUpRequest: SignUpRequest): SignUpResponse

    @POST("auth/login")
    fun signIn()

}
