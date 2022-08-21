package com.jammin.myapplication.feature.upload.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.ReportInTextField
import com.jammin.myapplication.data.model.request.comment.CreateCommentRequest
import com.jammin.myapplication.feature.upload.mvi.CommentSideEffect
import com.jammin.myapplication.feature.upload.vm.CommentVM
import com.jammin.myapplication.utils.observeWithLifecycle
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun CommentScreen(
    commentVM: CommentVM,
    navController: NavController,
    thesisId: String
) {
    val commentContainer = commentVM.container
    val commentState = commentContainer.stateFlow.collectAsState().value
    val commentSideEffect = commentContainer.sideEffectFlow

    commentSideEffect.observeWithLifecycle {
        when (it) {
            is CommentSideEffect.CreateCommentSuccess -> {
                navController.popBackStack()
            }
            is CommentSideEffect.CreateCommentFailed -> {
                navController.popBackStack()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Header(
            headerText = "Comment",
            enabledBackBtn = true,
            textBtn = "FINISH",
            onTextBtn = {
                commentVM.createComment(CreateCommentRequest(commentState.comment, thesisId))
            },
            onPrevious = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(
            value = commentState.comment,
            onValueChange = { commentVM.inputComment(it) })
    }
}
