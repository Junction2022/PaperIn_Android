package com.jammin.myapplication.feature.academic.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.feature.academic.mvi.AcademicSideEffect
import com.jammin.myapplication.feature.academic.mvi.AcademicState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AcademicVM @Inject constructor(
    private val thesisRepository: ThesisRepository
) : ContainerHost<AcademicState, AcademicSideEffect>, ViewModel() {

    override val container = container<AcademicState, AcademicSideEffect>(AcademicState())

    fun fetchThesisList() = intent {
        thesisRepository.getAllThesis()
            .onSuccess { reduce { state.copy(thesisList = it.thesisList) } }
            .onFailure { }
    }

    fun inputSearch(value: String) = intent {
        reduce { state.copy(searchValue = value) }
    }
}
