package com.jammin.myapplication.feature.signin.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
import com.jammin.myapplication.feature.signin.SignInEvent
import com.jammin.myapplication.feature.signin.vm.SignInVM

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInVM = hiltViewModel()
) {

    val idState = viewModel.signInId.value
    val passwordState = viewModel.signInPassword.value

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
            onValueChange = { viewModel.onEvent(SignInEvent.EnteredId(it)) },
            hint = idState.hint,
            round = 16.dp,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ReportInTextField(
            backgroundColor = JunctionColor.Gray100,
            value = passwordState.text,
            onValueChange = { viewModel.onEvent(SignInEvent.EnteredPassword(it)) },
            hint = passwordState.hint,
            round = 16.dp,
            isPassword = true,
            modifier = Modifier.height(48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        BigMainRoundButton(
            text = stringResource(id = R.string.text_ok),
            modifier = Modifier.height(48.dp),
            enabled = false
        ) {}
    }
}

@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen(navController = rememberNavController(), viewModel = hiltViewModel())
}
