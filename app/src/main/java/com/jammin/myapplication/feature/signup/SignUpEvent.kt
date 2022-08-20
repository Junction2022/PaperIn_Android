package com.jammin.myapplication.feature.signup

sealed class SignUpEvent {

    data class EnteredId(val value: String) : SignUpEvent()

    data class EnteredPassword(val value: String) : SignUpEvent()

    data class EnteredName(val value: String) : SignUpEvent()

    object OkEvent : SignUpEvent()
}
