package com.jammin.myapplication.feature.evaluation.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.feature.evaluation.mvi.EvaluationSideEffect
import com.jammin.myapplication.feature.evaluation.mvi.EvaluationState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class EvaluationVM @Inject constructor() : ContainerHost<EvaluationState, EvaluationSideEffect>, ViewModel() {

    override val container = container<EvaluationState, EvaluationSideEffect>(EvaluationState())
}
