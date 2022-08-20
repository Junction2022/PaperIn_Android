package com.jammin.myapplication.root

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jammin.myapplication.feature.academic.screen.AcademicScreen
import com.jammin.myapplication.feature.report_detail.screen.ReportDetailScreen

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
        startDestination = NavGroup.Boarding.REPORT_DETAIL,
        route = NavGroup.Boarding.group
    ) {
        composable(NavGroup.Boarding.ACADEMIC_HOME) {
            AcademicScreen(navController = navController, academicVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.REPORT_DETAIL) {
            ReportDetailScreen(navController = navController, reportDetailVM = hiltViewModel())
        }
    }
}
