package com.jammin.myapplication.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

//    @Singleton
//    @Binds
//    abstract fun providesRemoteNoticeRepository(
//        remoteNoticeDataSourceImpl: RemoteNoticeDataSourceImpl
//    ): RemoteNoticeDataSource
}