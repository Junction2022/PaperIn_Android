package com.jammin.myapplication.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body1

@Composable
fun Header(
    modifier: Modifier = Modifier,
    headerText: String,
    enabledBackBtn: Boolean = false,
    enabledChatBtn: Boolean = false,
    onPrevious: (() -> Unit)? = null,
    onMessage: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(38.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (enabledBackBtn) {
            IconButton(onClick = onPrevious ?: {}, modifier = Modifier.size(21.dp)) {
            Icon(
                painter = painterResource(id = JunctionIcon.Back),
                contentDescription = null
            )
        }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Body1(text = headerText)

        Spacer(modifier = Modifier.weight(1f))

        if (enabledChatBtn) {
            IconButton(onClick = onMessage ?: {}, modifier = Modifier.size(21.dp)) {
            Image(
                painter = painterResource(id = JunctionIcon.Message),
                contentDescription = null
            )
        }
        }
    }
}

@Preview
@Composable
fun PreviewHeader() {
    Column {
        Header(headerText = "전체 지점", enabledChatBtn = true)
    }
}
