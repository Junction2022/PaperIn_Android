package com.jammin.myapplication.feature.upload.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.feature.upload.mvi.UploadSideEffect
import com.jammin.myapplication.feature.upload.mvi.UploadState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.io.File
import javax.inject.Inject

@HiltViewModel
class UploadVM @Inject constructor(
    private val thesisRepository: ThesisRepository
) : ContainerHost<UploadState, UploadSideEffect>, ViewModel() {

    override val container =
        container<UploadState, UploadSideEffect>(UploadState())

    fun uploadFile(file: List<File>) = intent {
        kotlin.runCatching {
            thesisRepository.upload(file)
        }.onSuccess { }.onFailure { }

    }

    fun inputTitle(title: String) = intent {
        reduce { state.copy(titleValue = title) }
    }

    fun inputKeyword(keyword: String) = intent {
        reduce { state.copy(keyWordValue = keyword) }
    }

    fun inputFileState(upload: Boolean) = intent {
        reduce { state.copy(fileUpload = upload) }
    }
}
