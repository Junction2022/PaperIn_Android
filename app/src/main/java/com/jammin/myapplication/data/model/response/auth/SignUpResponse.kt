package com.jammin.myapplication.data.model.response.auth

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

    @field:SerializedName("user")
    val user: User,

    @field:SerializedName("tokens")
    val tokens: Tokens
) {

    data class User(

        @field:SerializedName("id")
        val id: String,

        @field:SerializedName("nickname")
        val nickname: String
    )

    data class Tokens(

        @field:SerializedName("access")
        val access: AccessToken,

        @field:SerializedName("refresh")
        val refresh: RefreshToken
    ) {
        data class AccessToken(

            @field:SerializedName("token")
            val token: String,

            @field:SerializedName("expires")
            val expires: String
        )

        data class RefreshToken(

            @field:SerializedName("token")
            val token: String,

            @field:SerializedName("expires")
            val expires: String
        )
    }
}
