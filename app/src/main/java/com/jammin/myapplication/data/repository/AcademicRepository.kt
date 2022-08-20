package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.response.AcademicResponse

interface AcademicRepository {

    suspend fun fetchAcademic(): Result<AcademicResponse>
}
