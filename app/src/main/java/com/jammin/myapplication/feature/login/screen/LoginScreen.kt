package com.jammin.myapplication.feature.login.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.core.component.BigMainRoundButton
import com.jammin.myapplication.core.component.SimTongTextField
import com.jammin.myapplication.core.theme.Body1
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.feature.login.LoginEvent
import com.jammin.myapplication.feature.login.vm.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
    // TODO : =hiltViewModel()
) {

    val idState = viewModel.loginId.value
    val passwordState = viewModel.loginPassword.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Body1(
            text = "SIGN IN",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 54.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        SimTongTextField(
            backgroundColor = JunctionColor.Gray100,
            value = idState.text,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredId(it)) },
            hint = idState.hint,
            round = 16.dp
        )
        Spacer(modifier = Modifier.height(8.dp))
        SimTongTextField(
            backgroundColor = JunctionColor.Gray100,
            value = passwordState.text,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
            hint = passwordState.hint,
            round = 16.dp,
            isPassword = true
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    val viewModel = LoginViewModel()
    val idState = viewModel.loginId.value
    val passwordState = viewModel.loginPassword.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Body1(
            text = "SIGN IN",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 54.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        SimTongTextField(
            backgroundColor = JunctionColor.Gray100,
            value = idState.text,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredId(it)) },
            hint = idState.hint,
            round = 16.dp,
            modifier = Modifier.height(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        SimTongTextField(
            backgroundColor = JunctionColor.Gray100,
            value = passwordState.text,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
            hint = passwordState.hint,
            round = 16.dp,
            isPassword = true,
            modifier = Modifier.height(48.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        BigMainRoundButton(
            text = "OK!",
            modifier = Modifier.height(48.dp),
            enabled = false
        ) {

        }
    }
}