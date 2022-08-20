package com.jammin.myapplication.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Singleton
//    @Binds
//    abstract fun providesNoticeRepository(
//        noticeRepositoryImpl: NoticeRepositoryImpl
//    ): NoticeRepository
}