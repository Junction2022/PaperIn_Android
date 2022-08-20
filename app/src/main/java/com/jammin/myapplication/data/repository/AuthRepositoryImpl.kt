package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.auth.SignInRequest
import com.jammin.myapplication.data.model.request.auth.SignUpRequest
import com.jammin.myapplication.data.model.response.auth.RefreshResponse
import com.jammin.myapplication.data.model.response.auth.SignInResponse
import com.jammin.myapplication.data.model.response.auth.SignUpResponse
import com.jammin.myapplication.data.network.AuthAPI
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthAPI
): AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequest): Result<SignUpResponse> =
        kotlin.runCatching {
            authApi.signUp(signUpRequest)
        }


    override suspend fun signIn(signInRequest: SignInRequest): Result<SignInResponse> =
        kotlin.runCatching {
            authApi.signIn(signInRequest)
        }

    override suspend fun refresh(refreshToken: String): Result<RefreshResponse> =
        kotlin.runCatching {
            authApi.refresh(refreshToken)
        }
}