package com.jammin.myapplication.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Singleton
//    @Binds
//    abstract fun providesNoticeRepository(
//        noticeRepositoryImpl: NoticeRepositoryImpl
//    ): NoticeRepository
}
