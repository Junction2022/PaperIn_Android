package com.jammin.myapplication.utils

import com.jammin.myapplication.core.component.TableModel
import com.jammin.myapplication.data.model.response.thesis.Thesis

fun Thesis.toTableList(): List<TableModel> {
    return listOf(
        TableModel("저자", author),
        TableModel("작성언어", language),
        TableModel("주제어", topic),
        TableModel("수록면", pageCount),
    )
}