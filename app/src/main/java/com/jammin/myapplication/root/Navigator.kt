package com.jammin.myapplication.root

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jammin.myapplication.feature.academic.screen.AcademicScreen
import com.jammin.myapplication.feature.evaluation.screen.EvaluationScreen
import com.jammin.myapplication.feature.profile.screen.MyPageScreen
import com.jammin.myapplication.feature.report_detail.screen.ReportDetailScreen
import com.jammin.myapplication.feature.report_detail.screen.ReportPaperScreen
import com.jammin.myapplication.feature.signin.screen.SignInScreen
import com.jammin.myapplication.feature.signup.screen.SignUpScreen
import com.jammin.myapplication.feature.upload.screen.UploadScreen

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
        startDestination = NavGroup.Boarding.ACADEMIC_HOME,
        route = NavGroup.OnBoarding.group
    ) {

        composable(NavGroup.OnBoarding.SIGN_IN) {
            SignInScreen(navController = navController, signInVm = hiltViewModel())
        }
        composable(NavGroup.OnBoarding.SIGN_UP) {
            SignUpScreen(navController = navController, signUpVm = hiltViewModel())
        }

        composable(NavGroup.Boarding.REPORT_DETAIL) {
            ReportDetailScreen(navController = navController, reportDetailVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.ACADEMIC_HOME) {
            AcademicScreen(navController = navController, academicVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.REPORT_PAPER) {
            ReportPaperScreen(navController = navController, reportDetailVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.REPORT_DETAIL) {
            ReportDetailScreen(navController = navController, reportDetailVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.REPORT_EVALUATION) {
            EvaluationScreen(navController = navController, evaluationVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.UPLOAD) {
            UploadScreen(navController = navController, uploadVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.MyPage) {
            MyPageScreen(navController = navController, myPageVM = hiltViewModel())
        }
    }
}
