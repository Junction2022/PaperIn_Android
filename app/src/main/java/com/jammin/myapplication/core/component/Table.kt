package com.jammin.myapplication.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.JunctionColor

data class TableModel(
    val title: String,
    val description: String
)

@Composable
fun TableList(
    modifier: Modifier = Modifier,
    tableModel: List<TableModel>
) {
    LazyColumn(
        modifier = modifier.border(
            width = 1.dp,
            color = JunctionColor.Gray100,
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        itemsIndexed(tableModel) { index, item ->
            Table(table = item)
        }
    }
}

@Composable
fun Table(
    shape: Shape = RectangleShape,
    table: TableModel
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(shape = shape, color = Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight()
                    .background(JunctionColor.BackgroundColor),
                contentAlignment = Alignment.CenterStart
            ) {
                Body3(
                    text = table.title,
                    color = JunctionColor.Gray300,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

            Body3(
                text = table.description,
                color = JunctionColor.Black,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Divider(thickness = 1.dp, color = JunctionColor.Gray100, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun PreviewTable() {
    Box(modifier = Modifier.padding(20.dp)) {
        TableList(
            tableModel = listOf(
                TableModel("123", "123"),
                TableModel("123", "123"),
                TableModel("123", "123")
            )
        )
    }
}
