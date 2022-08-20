package com.jammin.myapplication.root

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jammin.myapplication.feature.academic.screen.AcademicScreen
<<<<<<< HEAD
import com.jammin.myapplication.feature.signin.screen.SignInScreen
import com.jammin.myapplication.feature.signup.screen.SignUpScreen
=======
import com.jammin.myapplication.feature.report_detail.screen.ReportDetailScreen
>>>>>>> 15_auth_thesis_business_logic

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
<<<<<<< HEAD
        startDestination = NavGroup.OnBoarding.SIGN_IN,
=======
        startDestination = NavGroup.Boarding.REPORT_DETAIL,
>>>>>>> 15_auth_thesis_business_logic
        route = NavGroup.Boarding.group
    ) {
        composable(NavGroup.Boarding.ACADEMIC_HOME) {
            AcademicScreen(navController = navController, academicVM = hiltViewModel())
        }
<<<<<<< HEAD
        composable(NavGroup.OnBoarding.SIGN_IN) {
            SignInScreen(navController = navController, signInVm = hiltViewModel())
        }
        composable(NavGroup.OnBoarding.SIGN_UP) {
            SignUpScreen(navController = navController, signUpVm = hiltViewModel())
=======

        composable(NavGroup.Boarding.REPORT_DETAIL) {
            ReportDetailScreen(navController = navController, reportDetailVM = hiltViewModel())
>>>>>>> 15_auth_thesis_business_logic
        }
    }
}
