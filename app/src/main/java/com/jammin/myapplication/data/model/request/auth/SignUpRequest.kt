package com.jammin.myapplication.data.model.request.auth

import com.google.gson.annotations.SerializedName

data class SignUpRequest(

    @field:SerializedName("id") val id: String,
    @field:SerializedName("password") val password: String,
    @field:SerializedName("nickname") val nickname: String
)
