package com.jammin.myapplication.feature.signup.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.jammin.myapplication.feature.signup.SignUpEvent
import com.jammin.myapplication.feature.signup.vm.SignUpVM
import com.jammin.myapplication.root.NavGroup

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpVm: SignUpVM
) {

    val nameState = signUpVm.signUpName.value
    val idState = signUpVm.signUpId.value
    val passwordState = signUpVm.signUpPassword.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Body1(
            text = stringResource(R.string.title_sign_up),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 54.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = nameState.text,
            onValueChange = { signUpVm.onEvent(SignUpEvent.EnteredName(it)) },
            hint = nameState.hint,
            round = 16.dp,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = idState.text,
            onValueChange = { signUpVm.onEvent(SignUpEvent.EnteredId(it)) },
            hint = idState.hint,
            round = 16.dp,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = passwordState.text,
            onValueChange = { signUpVm.onEvent(SignUpEvent.EnteredPassword(it)) },
            hint = passwordState.hint,
            round = 16.dp,
            isPassword = true,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        BigMainRoundButton(
            text = stringResource(R.string.text_ok),
            modifier = Modifier.height(48.dp),
            enabled = false
        ) {}

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.text_sign_in),
            color = JunctionColor.Gray200,
            style = JunctionTypography.body3,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate(NavGroup.OnBoarding.SIGN_IN) {
                        popUpTo(NavGroup.OnBoarding.SIGN_UP) {
                            inclusive = true
                        }
                    }
                }
        )
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(navController = rememberNavController(), signUpVm = hiltViewModel())
}
