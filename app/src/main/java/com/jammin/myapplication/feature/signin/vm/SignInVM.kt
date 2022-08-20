package com.jammin.myapplication.feature.signin.vm

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jammin.myapplication.R
import com.jammin.myapplication.data.model.request.auth.SignInRequest
import com.jammin.myapplication.data.model.response.auth.SignInResponse
import com.jammin.myapplication.data.repository.AuthRepository
import com.jammin.myapplication.feature.signin.SignInEvent
import com.jammin.myapplication.feature.signin.SignInTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInVM @Inject constructor(
    application: Application,
    private val authRepository: AuthRepository
) : AndroidViewModel(application) {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

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
                viewModelScope.launch {
                    authRepository.signIn(
                        SignInRequest(
                            id = signInId.value.text,
                            password = signInPassword.value.text,
                        )
                    )
                        .onSuccess { _eventFlow.emit(UiEvent.SuccessSignIn(it)) }
                        .onFailure { _eventFlow.emit(UiEvent.FailSignIn) }
                }
            }
        }
    }

    sealed class UiEvent {
        data class SuccessSignIn(val signInResponse: SignInResponse) : UiEvent()
        object FailSignIn : UiEvent()
    }
}
