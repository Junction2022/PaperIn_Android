package com.jammin.myapplication.feature.login.vm

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jammin.myapplication.feature.login.LoginEvent
import com.jammin.myapplication.feature.login.LoginTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {

    private val _loginId = mutableStateOf(LoginTextFieldState(
        hint = "Id"
    ))
    val loginId: State<LoginTextFieldState> = _loginId

    private val _loginPassword = mutableStateOf(LoginTextFieldState(
        hint = "Password"
    ))
    val loginPassword: State<LoginTextFieldState> = _loginPassword

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EnteredId -> {
                _loginId.value = loginId.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.EnteredPassword -> {
                _loginPassword.value = loginPassword.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.OkEvent -> {
                Timber.tag("LoginViewModel").d("onEvent: 버튼 클릭")
            }
        }
    }

}