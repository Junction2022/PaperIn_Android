package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.auth.SignInRequest
import com.jammin.myapplication.data.model.request.auth.SignUpRequest
import com.jammin.myapplication.data.model.response.auth.RefreshResponse
import com.jammin.myapplication.data.model.response.auth.SignInResponse
import com.jammin.myapplication.data.model.response.auth.SignUpResponse

interface AuthRepository {

    suspend fun signUp(signUpRequest: SignUpRequest): Result<SignUpResponse>

    suspend fun signIn(signInRequest: SignInRequest): Result<SignInResponse>

    suspend fun refresh(refreshToken: String): Result<RefreshResponse>
}
