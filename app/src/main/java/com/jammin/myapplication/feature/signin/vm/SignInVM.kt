package com.jammin.myapplication.feature.signin.vm

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.jammin.myapplication.R
import com.jammin.myapplication.feature.signin.SignInEvent
import com.jammin.myapplication.feature.signin.SignInTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInVM @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val _signInId = mutableStateOf(
        SignInTextFieldState(
            hint = application.getString(R.string.hint_id)
        )
    )
    val signInId: State<SignInTextFieldState> = _signInId

    private val _signInPassword = mutableStateOf(
        SignInTextFieldState(
            hint = application.getString(R.string.hint_password)
        )
    )
    val signInPassword: State<SignInTextFieldState> = _signInPassword

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.EnteredId -> {
                _signInId.value = signInId.value.copy(
                    text = event.value
                )
            }
            is SignInEvent.EnteredPassword -> {
                _signInPassword.value = signInPassword.value.copy(
                    text = event.value
                )
            }
            is SignInEvent.OkEvent -> {
                Timber.tag("SignInVM").d("onEvent: OK 버튼 클릭")
            }
        }
    }
}
