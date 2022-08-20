package com.jammin.myapplication.data.mapper

import com.jammin.myapplication.core.component.TableModel
import com.jammin.myapplication.data.model.FetchReportDetailEntity

fun FetchReportDetailEntity.TableModel.toModel() =
    TableModel(
        title = title,
        description = description
    )