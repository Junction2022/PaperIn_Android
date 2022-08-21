package com.jammin.myapplication.feature.academic.mvi

import com.jammin.myapplication.data.model.response.thesis.Thesis

data class AcademicState(
    val isLoading: Boolean = false,
    val searchValue: String = "",
    val thesisList: List<Thesis> = listOf()
)
