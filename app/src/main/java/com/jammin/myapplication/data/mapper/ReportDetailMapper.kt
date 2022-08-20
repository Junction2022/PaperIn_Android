package com.jammin.myapplication.data.mapper

import com.jammin.myapplication.core.component.TableModel
import com.jammin.myapplication.data.model.response.FetchReportDetailResponse

fun FetchReportDetailResponse.TableModel.toModel() =
    TableModel(
        title = title,
        description = description
    )
