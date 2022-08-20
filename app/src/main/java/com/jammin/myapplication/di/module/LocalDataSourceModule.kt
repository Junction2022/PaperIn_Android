package com.jammin.myapplication.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

//    @Singleton
//    @Binds
//    abstract fun providesLocalNoticeRepository(
//        localNoticeDataSourceImpl: LocalNoticeDataSourceImpl
//    ): LocalNoticeDataSource
}
