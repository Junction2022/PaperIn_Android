package com.jammin.myapplication.feature.upload.mvi

import java.util.*

sealed class CommentSideEffect {

    object CreateCommentSuccess : CommentSideEffect()

    object CreateCommentFailed : CommentSideEffect()
}
