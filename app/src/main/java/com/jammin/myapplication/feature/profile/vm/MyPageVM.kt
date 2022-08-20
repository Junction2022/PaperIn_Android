package com.jammin.myapplication.feature.profile.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.feature.profile.model.MyPageSideEffect
import com.jammin.myapplication.feature.profile.mvi.MyPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MyPageVM @Inject constructor() : ContainerHost<MyPageState, MyPageSideEffect>, ViewModel() {

    override val container = container<MyPageState, MyPageSideEffect>(MyPageState())
}
