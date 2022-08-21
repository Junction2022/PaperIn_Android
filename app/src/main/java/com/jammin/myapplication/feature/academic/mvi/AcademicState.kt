package com.jammin.myapplication.feature.academic.mvi

import com.jammin.myapplication.data.model.response.thesis.Thesis
import com.jammin.myapplication.data.model.response.thesis.ThesisX

data class AcademicState(
    val isLoading: Boolean = false,
    val searchValue: String = "",
    val thesisList: List<ThesisX> = listOf()
)
