package com.jammin.myapplication.data.repository

import android.webkit.MimeTypeMap
import com.jammin.myapplication.data.model.request.thesis.CreateThesisRequest
import com.jammin.myapplication.data.model.response.thesis.GetAllThesisResponse
import com.jammin.myapplication.data.model.response.thesis.ThesisResponse
import com.jammin.myapplication.data.network.ThesisAPI
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.Random
import javax.inject.Inject

class ThesisRepositoryImpl @Inject constructor(
    private val api: ThesisAPI
) : ThesisRepository {

    private lateinit var fileBody: MultipartBody

    override suspend fun getAllThesis(): Result<GetAllThesisResponse> {
        return kotlin.runCatching {
            api.getAllThesis()
        }
    }

    override suspend fun getThesis(thesisId: String): Result<ThesisResponse> {
        return kotlin.runCatching {
            api.getThesis(thesisId)
        }
    }

    override suspend fun createThesis(createThesisRequest: CreateThesisRequest): Result<ThesisResponse> {
        return kotlin.runCatching {
            api.createThesis(createThesisRequest)
        }
    }

    override suspend fun upload(fileList: List<File>): String {
        setFileMultipartBodyPartList(fileList)
        return api.upload(fileBody)
    }

    private fun setFileMultipartBodyPartList(files: List<File>) {
        val fileBuilder: MultipartBody.Builder = MultipartBody.Builder().setType(MultipartBody.FORM)
        val nameBuilder: MultipartBody.Builder = MultipartBody.Builder().setType(MultipartBody.FORM)

        for (file in files) {
            val uploadName = "DA_FILE_${Random().nextInt(Int.MAX_VALUE)}"

            val extension = getExtension(file)
            val mediaType = getMediaType(extension)
            val fileBody: RequestBody = RequestBody.create(mediaType.toMediaTypeOrNull(), file)

            fileBuilder.addFormDataPart("file", "$uploadName.$extension", fileBody)
            nameBuilder.addFormDataPart("name", uploadName)
        }

        fileBody = fileBuilder.build()
    }

    private fun getMediaType(extension: String): String {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)!!
    }

    private fun getExtension(file: File): String {
        val filenameArray: Array<String> = file.name.split(".").toTypedArray()
        return filenameArray[filenameArray.size - 1]
    }
}
