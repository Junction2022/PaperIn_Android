package com.jammin.myapplication.feature.academic.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.feature.academic.mvi.AcademicSideEffect
import com.jammin.myapplication.feature.academic.mvi.AcademicState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AcademicVM @Inject constructor(
    private val thesisRepository: ThesisRepository
) : ContainerHost<AcademicState, AcademicSideEffect>, ViewModel() {

    override val container = container<AcademicState, AcademicSideEffect>(AcademicState())

    fun fetchThesisList() = intent {
        try {
            val data = thesisRepository.getAllThesis()
            Log.d("MainTest", "fetchThesisList: ${data}")
            reduce { state.copy(thesisList = data.thesisList) }
        } catch (e: Exception) {

        }

    }

    fun inputSearch(value: String) = intent {
        reduce { state.copy(searchValue = value) }
    }
}
