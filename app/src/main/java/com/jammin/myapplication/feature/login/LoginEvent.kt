package com.jammin.myapplication.feature.login

sealed class LoginEvent {
    data class EnteredId(val value: String) : LoginEvent()
    data class EnteredPassword(val value: String) : LoginEvent()
    object OkEvent: LoginEvent()
}