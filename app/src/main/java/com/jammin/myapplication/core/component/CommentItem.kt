package com.jammin.myapplication.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.Body4
import com.jammin.myapplication.core.theme.JunctionColor

data class CommentModel(
    val comment: String = "",
    val likeNum: Int = 0,
    val disLikeNum: Int = 0,
    val agoTime: String = ""
)

@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    commentModel: CommentModel
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp))
            .background(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            )
            .padding(16.dp)
    ) {
        Column() {
            Body3(text = commentModel.comment)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = JunctionIcon.Good(true)),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(7.dp))

                Body4(text = commentModel.likeNum.toString(), color = JunctionColor.Gray300)

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = JunctionIcon.Good(false)),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(7.dp))

                Body4(text = commentModel.disLikeNum.toString(), color = JunctionColor.Gray300)
            }
        }
    }
}

@Preview
@Composable
fun PreviewComment() {
    CommentItem(commentModel = CommentModel("코멘트입니다.", 123, 123, "1 hour ago"))
}
