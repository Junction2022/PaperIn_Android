package com.jammin.myapplication.feature.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.R
import com.jammin.myapplication.core.component.CommentItem
import com.jammin.myapplication.core.component.ReportItem
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.Body2
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.core.theme.JunctionColor
import com.jammin.myapplication.feature.profile.vm.MyPageVM

@Composable
fun MyPageScreen(
    myPageVM: MyPageVM,
    navController: NavController
) {

    val myPageContainer = myPageVM.container
    val myPageState = myPageContainer.stateFlow.collectAsState().value
    val myPageSideEffect = myPageContainer.sideEffectFlow

    LaunchedEffect(Unit) {
    }

    Column() {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = myPageState.tier.layoutId),
                contentDescription = null
            )

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(25.dp)
            ) {
                Icon(painter = painterResource(id = JunctionIcon.Back), contentDescription = null)
            }

            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.BottomStart)
            )
        }

        Column(modifier = Modifier.padding(20.dp)) {
            Body2(text = myPageState.nickname ?: "unknown")

            Spacer(modifier = Modifier.height(36.dp))

            Row() {
                Body3(
                    text = myPageState.academicPageNum.toString(),
                    color = JunctionColor.MainColor
                )

                Spacer(modifier = Modifier.width(4.dp))

                Body3(text = "Academic Pager")
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow() {
                itemsIndexed(myPageState.reportModel) { index, item ->

                    ReportItem(title = item.title, categoryList = item.category)

                    Spacer(modifier = Modifier.width(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row() {
                Body3(
                    text = myPageState.commentNum.toString(),
                    color = JunctionColor.MainColor
                )

                Spacer(modifier = Modifier.width(4.dp))

                Body3(text = "Comment")
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow() {
                itemsIndexed(myPageState.commentModel) { index, item ->

                    CommentItem(commentModel = item)

                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyPageScreen() {
    MyPageScreen(myPageVM = hiltViewModel(), navController = rememberNavController())
}
