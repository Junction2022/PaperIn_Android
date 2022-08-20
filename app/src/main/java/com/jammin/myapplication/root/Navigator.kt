package com.jammin.myapplication.root

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jammin.myapplication.feature.academic.screen.AcademicScreen

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
        startDestination = NavGroup.Boarding.ACADEMIC_HOME,
        route = NavGroup.Boarding.group
    ) {
        composable(NavGroup.Boarding.ACADEMIC_HOME) {
            AcademicScreen(navController = navController, academicVM = hiltViewModel())
        }
    }
}
