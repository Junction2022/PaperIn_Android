package com.jammin.myapplication.feature.academic.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.R
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.OutlineButton
import com.jammin.myapplication.core.component.PlusButton
import com.jammin.myapplication.core.component.ReportInTextField
import com.jammin.myapplication.core.component.ReportItem
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.feature.academic.vm.AcademicVM
import com.jammin.myapplication.feature.report_detail.screen.ReportPaperScreen
import com.jammin.myapplication.root.NavGroup

@Composable
fun AcademicScreen(
    academicVM: AcademicVM,
    navController: NavController
) {

    val academicContainer = academicVM.container
    val academicState = academicContainer.stateFlow.collectAsState().value
    val academicSideEffect = academicContainer.sideEffectFlow

    LaunchedEffect(Unit) {
        academicVM.fetchReportList()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(JunctionColor.BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Header(headerText = stringResource(id = R.string.academic_pager))

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ReportInTextField(
                    backgroundColor = JunctionColor.Gray100,
                    value = academicState.searchValue,
                    onValueChange = { academicVM.inputSearch(it) },
                    hint = "이곳에 검색해보세요.",
                    modifier = Modifier.fillMaxWidth(0.85f)
                )

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(JunctionColor.Gray200)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn() {
                itemsIndexed(academicState.reportList) { index, item ->
                    item.run {
                        ReportItem(
                            title = title,
                            categoryList = category,
                            onClick = { navController.navigate(NavGroup.Boarding.REPORT_PAPER) }
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlineButton(
                text = "More",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                textColor = Color.Black
            ) {
            }
        }

        PlusButton(
            enabled = true,
            contentDescription = null,
            modifier = Modifier
                .padding(all = 16.dp)
                .size(48.dp)
                .align(alignment = Alignment.BottomEnd),
        ) {
            navController.navigate(NavGroup.Boarding.UPLOAD)
        }
    }
}
