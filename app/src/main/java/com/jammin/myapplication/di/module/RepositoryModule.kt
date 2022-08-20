package com.jammin.myapplication.di.module

import com.jammin.myapplication.data.repository.AcademicRepository
import com.jammin.myapplication.data.repository.AcademicRepositoryImpl
import com.jammin.myapplication.data.repository.ReportDetailRepository
import com.jammin.myapplication.data.repository.ReportDetailResponseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesAcademicRepository(
        academicRepositoryImpl: AcademicRepositoryImpl
    ): AcademicRepository

    @Singleton
    @Binds
    abstract fun providesReportDetailRepository(
        reportDetailResponseImpl: ReportDetailResponseImpl
    ): ReportDetailRepository
}
