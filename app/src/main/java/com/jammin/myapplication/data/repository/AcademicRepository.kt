package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.AcademicEntity

interface AcademicRepository {

    suspend fun fetchAcademic(): Result<AcademicEntity>
}
