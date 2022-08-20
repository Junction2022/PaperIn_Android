package com.jammin.myapplication.feature.signup.vm

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.jammin.myapplication.R
import com.jammin.myapplication.feature.signup.SignUpEvent
import com.jammin.myapplication.feature.signup.SignUpTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpVM @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val _signUpName = mutableStateOf(
        SignUpTextFieldState(
            hint = application.getString(R.string.hint_name)
        )
    )
    val signUpName: State<SignUpTextFieldState> = _signUpName

    private val _signUpId = mutableStateOf(
        SignUpTextFieldState(
            hint = application.getString(R.string.hint_id)
        )
    )
    val signUpId: State<SignUpTextFieldState> = _signUpId

    private val _signUpPassword = mutableStateOf(
        SignUpTextFieldState(
            hint = application.getString(R.string.hint_password)
        )
    )
    val signUpPassword: State<SignUpTextFieldState> = _signUpPassword

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.EnteredName -> {
                _signUpName.value = _signUpName.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.EnteredId -> {
                _signUpId.value = _signUpId.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.EnteredPassword -> {
                _signUpPassword.value = signUpPassword.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.OkEvent -> {
                Timber.tag("JoinViewModel").d("onEvent: 버튼 클릭")
            }
        }
    }
}
