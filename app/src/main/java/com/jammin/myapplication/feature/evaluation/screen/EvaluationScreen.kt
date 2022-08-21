package com.jammin.myapplication.feature.evaluation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.core.component.CommentItem
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.feature.evaluation.vm.EvaluationVM
import com.jammin.myapplication.root.NavGroup

@Composable
fun EvaluationScreen(
    navController: NavController,
    evaluationVM: EvaluationVM
) {

    val evaluationContainer = evaluationVM.container
    val evaluationState = evaluationContainer.stateFlow.collectAsState().value
    val evaluationSideEffect = evaluationContainer.sideEffectFlow

    LaunchedEffect(Unit) {
    }

    Column() {
        Header(
            headerText = "Evaluation",
            enabledBackBtn = true,
            enabledEditBtn = true,
            onEdit = { navController.navigate(NavGroup.Boarding.Comment) },
            onPrevious = { navController.popBackStack() }
        )


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn() {
            itemsIndexed(evaluationState.comments) { index, item ->
                CommentItem(commentModel = item)

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewEvaluationScreen() {
    EvaluationScreen(rememberNavController(), hiltViewModel())
}
