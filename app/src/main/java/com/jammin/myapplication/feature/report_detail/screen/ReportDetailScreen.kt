package com.jammin.myapplication.feature.report_detail.screen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.PeopleCard
import com.jammin.myapplication.core.component.TableList
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.feature.report_detail.vm.ReportDetailVM

@Composable
fun ReportDetailScreen(
    reportDetailVM: ReportDetailVM,
    navController: NavController
) {

    val reportDetailContainer = reportDetailVM.container
    val reportDetailState = reportDetailContainer.stateFlow.collectAsState().value
    val reportDetailSideEffect = reportDetailContainer.sideEffectFlow


    Column(modifier = Modifier.fillMaxSize()) {
        Header(headerText = "Detail") {
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(16.dp))

        TableList(tableModel = reportDetailState.tableList)

        Spacer(modifier = Modifier.height(32.dp))

        LazyRow() {
            itemsIndexed(reportDetailState.names) { index, item ->
                PeopleCard(name = item)

                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun ScoreBoard() {
    Column() {
        Body3(text = "0")
    }
}