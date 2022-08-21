package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.request.thesis.CreateThesisRequest
import com.jammin.myapplication.data.model.response.thesis.GetAllThesisResponse
import com.jammin.myapplication.data.model.response.thesis.ThesisResponse
import java.io.File

interface ThesisRepository {

    suspend fun getAllThesis(): GetAllThesisResponse

    suspend fun getThesis(thesisId: String): Result<ThesisResponse>

    suspend fun createThesis(createThesisRequest: CreateThesisRequest): Result<ThesisResponse>

    suspend fun upload(fileList: List<File>): String
}
