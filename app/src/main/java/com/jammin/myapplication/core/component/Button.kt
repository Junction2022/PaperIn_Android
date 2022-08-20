package com.jammin.myapplication.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.theme.Body1
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

@Composable
fun BigSmallRoundButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BasicSmallButton(
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

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(round),
        enabled = enabled
    ) {
        Body1(text = text, color = Color.White)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    Column(modifier = Modifier.background(JunctionColor.Gray100)) {
        BigMainRoundButton(text = "로그인") {
        }

        BigSmallRoundButton(text = "로그인") {
        }

        OutlineButton(text = "123") {
        }
    }
}
