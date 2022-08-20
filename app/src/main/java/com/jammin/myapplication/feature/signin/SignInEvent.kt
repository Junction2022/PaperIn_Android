package com.jammin.myapplication.feature.signin

sealed class SignInEvent {
    data class EnteredId(val value: String) : SignInEvent()
    data class EnteredPassword(val value: String) : SignInEvent()
    object OkEvent : SignInEvent()
}
