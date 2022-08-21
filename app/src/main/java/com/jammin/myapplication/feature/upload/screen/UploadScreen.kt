package com.jammin.myapplication.feature.upload.screen

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.PDFBox
import com.jammin.myapplication.core.component.ReportInTextField
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body2
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.feature.upload.vm.UploadVM
import java.io.File

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
                    uploadVM.inputFileState(true)

                    val file = File(uri.toString())
                    uploadVM.uploadFile(listOf(file))

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Header(
            headerText = "Produce",
            textBtn = "Save",
            onTextBtn = { navController.popBackStack() },
            enabledBackBtn = true,
            onPrevious = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(
            value = uploadState.titleValue,
            onValueChange = { uploadVM.inputTitle(it) },
            hint = "TITLE",
            backgroundColor = JunctionColor.BackgroundColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        ReportInTextField(
            value = uploadState.keyWordValue,
            onValueChange = { uploadVM.inputKeyword(it) },
            hint = "KEYWORD",
            backgroundColor = JunctionColor.BackgroundColor
        )

        if (!uploadState.fileUpload) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                PDFBox() {
                    takePhotoFromAlbumLauncher.launch(takePhotoFromAlbumIntent)
                }
            }
        } else {
            FileBlock(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clickable {
                        uploadVM.inputFileState(false)
                    }
            )
        }
    }
}

@Composable
fun FileBlock(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(83.dp)
            .background(
                color = JunctionColor.BackgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = JunctionIcon.PDF), contentDescription = null)

        Spacer(modifier = Modifier.width(12.dp))

        Body2(text = "첨부파일 1.pdf", color = JunctionColor.Gray300)
    }
}

@Preview
@Composable
fun PreviewUploadScreen() {
    UploadScreen(uploadVM = hiltViewModel(), navController = rememberNavController())
}
