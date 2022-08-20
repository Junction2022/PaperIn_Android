package com.jammin.myapplication.core.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.theme.JunctionColor

@Composable
fun BigMainRoundButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BasicRoundButton(
        round = round,
        modifier = modifier,
        text = text,
        shape = RoundedCornerShape(round),
        onClick = onClick,
        backgroundColor = JunctionColor.MainColor,
        pressedBackgroundColor = JunctionColor.PressedColor,
        disabledBackgroundColor = JunctionColor.SubColor,
        textColor = JunctionColor.White,
        disabledTextColor = JunctionColor.White,
        enabled = enabled
    )
}

@Preview
@Composable
fun ButtonPreview() {
    BigMainRoundButton(text = "로그인") {

    }
}