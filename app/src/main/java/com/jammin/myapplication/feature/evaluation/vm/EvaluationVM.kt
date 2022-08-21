package com.jammin.myapplication.feature.evaluation.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.feature.evaluation.mvi.EvaluationSideEffect
import com.jammin.myapplication.feature.evaluation.mvi.EvaluationState
import com.jammin.myapplication.utils.mapToModel
import com.jammin.myapplication.utils.toTableList
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class EvaluationVM @Inject constructor(
    private val thesisRepository: ThesisRepository
) : ContainerHost<EvaluationState, EvaluationSideEffect>, ViewModel() {

    override val container = container<EvaluationState, EvaluationSideEffect>(EvaluationState())

    fun getThesisDetail(thesisId: String) = intent {
        thesisRepository.getThesis(thesisId)
            .onSuccess {
                reduce {
                    state.copy(
                        comments = it.thesis.comments.map { it.mapToModel() }
                    )
                }
            }
            .onFailure { }
    }
}
