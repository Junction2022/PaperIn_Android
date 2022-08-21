package com.jammin.myapplication.feature.upload.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.ReportInTextField

@Composable
fun CommentScreen(
    navController: NavController
) {

    var comment by remember { mutableStateOf<String>("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Header(
            headerText = "Comment",
            enabledBackBtn = true,
            textBtn = "FINISH",
            onTextBtn = { navController.popBackStack() },
            onPrevious = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(value = comment, onValueChange = { comment = it })
    }
}
