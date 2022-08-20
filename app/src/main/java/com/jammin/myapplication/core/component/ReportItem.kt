package com.jammin.myapplication.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.jammin.myapplication.core.theme.Body2
import com.jammin.myapplication.core.theme.Body4
import com.jammin.myapplication.core.theme.JunctionColor

@Composable
fun ReportItem(
    modifier: Modifier = Modifier,
    title: String,
    categoryList: List<String>
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp))
            .background(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            )
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Column() {
            Body2(text = title)

            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 8.dp,
            ) {
                categoryList.forEach { item ->
                    CategoryItem(category = item)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: String
) {
    Surface(
        modifier = Modifier
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = JunctionColor.Gray100
            )
    ) {
        Body4(text = category, color = JunctionColor.Gray200, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
    }
}

@Preview
@Composable
fun PreviewReportItem() {
    ReportItem(
        title = "마이스터고 운영 실태 분석 : 부산자동차 마이스터고 사례를 중심으로",
        categoryList = listOf("안녕", "하세요", "테스트테스트세트스테스트세트ㅡ", "입니다")
    )
}
