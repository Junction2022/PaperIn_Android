package com.jammin.myapplication.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.JunctionColor

@Composable
fun PeopleCard(name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = JunctionIcon.Profile), contentDescription = null)
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Body3(text = name, color = JunctionColor.Gray200)
    }
}