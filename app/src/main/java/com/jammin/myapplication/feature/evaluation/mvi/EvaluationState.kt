package com.jammin.myapplication.feature.evaluation.mvi

import com.jammin.myapplication.core.component.CommentModel

data class EvaluationState(
    val isLoading: Boolean = false,
    val comments: List<CommentModel> = listOf()
)
