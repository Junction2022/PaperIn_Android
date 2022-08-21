package com.jammin.myapplication.feature.upload.vm

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.data.repository.CommentRepository
import com.jammin.myapplication.feature.upload.mvi.CommentSideEffect
import com.jammin.myapplication.feature.upload.mvi.CommentState
import com.jammin.myapplication.feature.upload.mvi.UploadSideEffect
import com.jammin.myapplication.feature.upload.mvi.UploadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommentVM @Inject constructor(
    private val commentRepository: CommentRepository
) : ContainerHost<CommentState, CommentSideEffect>, ViewModel() {

    override val container =
        container<CommentState, CommentSideEffect>(CommentState())

    fun createComment(request: CreateCommentRequest) = intent {
        viewModelScope.launch {
            kotlin.runCatching {
                commentRepository.createComment(request)
            }.onSuccess {
                postSideEffect(CommentSideEffect.CreateCommentSuccess)
            }.onFailure {
                postSideEffect(CommentSideEffect.CreateCommentFailed)
            }
        }
    }

    fun inputComment(comment: String) = intent {
        reduce { state.copy(comment = comment) }
    }

}