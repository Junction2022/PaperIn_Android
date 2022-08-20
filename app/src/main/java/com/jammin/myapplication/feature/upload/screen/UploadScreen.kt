package com.jammin.myapplication.feature.upload.screen

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.PDFBox
import com.jammin.myapplication.core.component.ReportInTextField
import com.jammin.myapplication.feature.upload.vm.UploadVM

@Composable
fun UploadScreen(
    uploadVM: UploadVM,
    navController: NavController
) {
    val uploadContainer = uploadVM.container
    val uploadState = uploadContainer.stateFlow.collectAsState().value
    val uploadSideEffect = uploadContainer.sideEffectFlow

    LaunchedEffect(Unit) {
    }

    val takePhotoFromAlbumLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    Log.d("PDF", "UploadScreen: + $uri")
                } ?: run {
                    // Failed
                }
            } else if (result.resultCode != Activity.RESULT_CANCELED) {
                // Failed
            }
        }

    val takePhotoFromAlbumIntent =
        Intent(
            Intent.ACTION_GET_CONTENT,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        ).apply {
            type = "application/*"
            action = Intent.ACTION_GET_CONTENT
            putExtra(
                Intent.EXTRA_MIME_TYPES,
                arrayOf("application/pdf")
            )
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        }

    Column(modifier = Modifier.fillMaxSize()) {
        Header(headerText = "Produce", textBtn = "Save", onTextBtn = {})

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(
            value = uploadState.titleValue,
            onValueChange = { uploadVM.inputTitle(it) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ReportInTextField(
            value = uploadState.keyWordValue,
            onValueChange = { uploadVM.inputKeyword(it) }
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            PDFBox() {
                takePhotoFromAlbumLauncher.launch(takePhotoFromAlbumIntent)
            }
        }
    }
}

@Preview
@Composable
fun PreviewUploadScreen() {
    UploadScreen(uploadVM = hiltViewModel(), navController = rememberNavController())
}
