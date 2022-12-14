package com.jammin.myapplication.root

sealed class NavGroup(val group: String) {

    object OnBoarding : NavGroup("onBoarding") {
        const val AUTH_HOME = "authHome"
        const val SIGN_IN = "signIn"
        const val SIGN_UP = "signUp"
    }

    object Boarding : NavGroup("boarding") {
        const val ACADEMIC_HOME = "academicHome"

        const val UPLOAD = "upload"

        const val REPORT_DETAIL = "reportDetail"
        const val REPORT_PAPER = "reportPaper"
        const val REPORT_EVALUATION = "reportEvaluation"

        const val MyPage = "MyPage"

        const val Academic = "Academic"

        const val Comment = "Comment"
    }
}
