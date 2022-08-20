package com.jammin.myapplication.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.JunctionColor

@Composable
fun PDFBox(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
            .background(JunctionColor.BackgroundColor)
            .clickable{
                onClick()
            },
        contentAlignment = Alignment.Center

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = JunctionIcon.PDF), contentDescription = null)

            Spacer(modifier = Modifier.height(6.dp))

            Body3(text = (".pdf파일 업로드"))
        }
    }
}

@Preview
@Composable
fun PreviewPDFBox() {
    PDFBox() {

    }
}