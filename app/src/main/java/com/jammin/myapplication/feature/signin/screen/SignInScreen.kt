package com.jammin.myapplication.feature.signin.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.R
import com.jammin.myapplication.core.component.BigMainRoundButton
import com.jammin.myapplication.core.component.ReportInTextField
import com.jammin.myapplication.core.theme.Body1
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.core.theme.JunctionTypography
import com.jammin.myapplication.feature.signin.SignInEvent
import com.jammin.myapplication.feature.signin.vm.SignInVM
import com.jammin.myapplication.root.NavGroup
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@Composable
fun SignInScreen(
    navController: NavController,
    signInVm: SignInVM = hiltViewModel()
) {

    val idState = signInVm.signInId.value
    val passwordState = signInVm.signInPassword.value

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(Unit) {
        signInVm.eventFlow.collectLatest { event ->
            when(event) {
                is SignInVM.UiEvent.SuccessSignIn -> {
                    Timber.d(event.signInResponse.tokens.refresh.token)
                    navigateToHome(navController)
                }
                is SignInVM.UiEvent.FailSignIn -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "로그인에 실패했습니다."
                    )
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Body1(
            text = stringResource(id = R.string.title_sign_in),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 54.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = idState.text,
            onValueChange = { signInVm.onEvent(SignInEvent.EnteredId(it)) },
            hint = idState.hint,
            round = 16.dp,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = passwordState.text,
            onValueChange = { signInVm.onEvent(SignInEvent.EnteredPassword(it)) },
            hint = passwordState.hint,
            round = 16.dp,
            isPassword = true,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        BigMainRoundButton(
            text = stringResource(id = R.string.text_ok),
            modifier = Modifier.height(48.dp),
            enabled = true,
            onClick = {
                navigateToHome(navController)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.text_sign_up),
            color = JunctionColor.Gray200,
            style = JunctionTypography.body3,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .align(CenterHorizontally)
                .clickable {
                    navController.navigate(NavGroup.OnBoarding.SIGN_UP) {
                        popUpTo(NavGroup.OnBoarding.SIGN_IN) {
                            inclusive = true
                        }
                    }
                }
        )
    }
}

private fun navigateToHome(navController: NavController) {
    navController.navigate(NavGroup.Boarding.ACADEMIC_HOME)
}

@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen(navController = rememberNavController(), signInVm = hiltViewModel())
}
