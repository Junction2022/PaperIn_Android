package com.jammin.myapplication.di.module

import com.jammin.myapplication.data.repository.AcademicRepository
import com.jammin.myapplication.data.repository.AcademicRepositoryImpl
import com.jammin.myapplication.data.repository.AuthRepository
import com.jammin.myapplication.data.repository.AuthRepositoryImpl
import com.jammin.myapplication.data.repository.CommentRepository
import com.jammin.myapplication.data.repository.CommentRepositoryImpl
import com.jammin.myapplication.data.repository.ReportDetailRepository
import com.jammin.myapplication.data.repository.ReportDetailResponseImpl
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.data.repository.ThesisRepositoryImpl
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

    @Singleton
    @Binds
    abstract fun providesAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Singleton
    @Binds
    abstract fun providesThesisRepository(
        thesisRepositoryImpl: ThesisRepositoryImpl
    ): ThesisRepository

    @Singleton
    @Binds
    abstract fun providesCommentRepository(
        commentRepositoryImpl: CommentRepositoryImpl
    ): CommentRepository
}
