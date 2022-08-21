package com.jammin.myapplication.root

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jammin.myapplication.feature.academic.screen.AcademicScreen
import com.jammin.myapplication.feature.evaluation.screen.EvaluationScreen
import com.jammin.myapplication.feature.profile.screen.MyPageScreen
import com.jammin.myapplication.feature.report_detail.screen.ReportDetailScreen
import com.jammin.myapplication.feature.report_detail.screen.ReportPaperScreen
import com.jammin.myapplication.feature.signin.screen.SignInScreen
import com.jammin.myapplication.feature.signup.screen.SignUpScreen
import com.jammin.myapplication.feature.upload.screen.CommentScreen
import com.jammin.myapplication.feature.upload.screen.UploadScreen

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
        startDestination = NavGroup.OnBoarding.SIGN_IN,
        route = NavGroup.OnBoarding.group
    ) {

        composable(NavGroup.OnBoarding.SIGN_IN) {
            SignInScreen(navController = navController, signInVm = hiltViewModel())
        }
        composable(NavGroup.OnBoarding.SIGN_UP) {
            SignUpScreen(navController = navController, signUpVm = hiltViewModel())
        }

        composable(
            route = NavGroup.Boarding.REPORT_DETAIL + "?thesisId={thesisId}",
            arguments = listOf(
                navArgument(name = "thesisId") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val thesisId = it.arguments?.getString("thesisId") ?: ""
            ReportDetailScreen(
                navController = navController,
                reportDetailVM = hiltViewModel(),
                thesisId = thesisId
            )
        }

        composable(NavGroup.Boarding.ACADEMIC_HOME) {
            AcademicScreen(navController = navController, academicVM = hiltViewModel())
        }

        composable(
            route = NavGroup.Boarding.REPORT_PAPER + "?thesisId={thesisId}",
            arguments = listOf(
                navArgument(name = "thesisId") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val thesisId = it.arguments?.getString("thesisId") ?: ""

            ReportPaperScreen(navController = navController, reportDetailVM = hiltViewModel(), thesisId = thesisId)
        }

/*        composable(NavGroup.Boarding.REPORT_DETAIL) {
            ReportDetailScreen(navController = navController, reportDetailVM = hiltViewModel())
        }*/

        composable(
            route = NavGroup.Boarding.REPORT_EVALUATION + "?thesisId={thesisId}",
            arguments = listOf(
                navArgument(name = "thesisId") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val thesisId = it.arguments?.getString("thesisId") ?: ""
            EvaluationScreen(
                navController = navController,
                evaluationVM = hiltViewModel(),
                thesisId = thesisId
            )
        }

        composable(NavGroup.Boarding.UPLOAD) {
            UploadScreen(navController = navController, uploadVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.MyPage) {
            MyPageScreen(navController = navController, myPageVM = hiltViewModel())
        }

        composable(NavGroup.Boarding.Comment) {
            CommentScreen(navController = navController)
        }
    }
}
