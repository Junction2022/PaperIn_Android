package com.jammin.myapplication.di.module

import android.content.Context
import androidx.room.Room
import com.jammin.myapplication.data.local.JunctionDao
import com.jammin.myapplication.data.local.JunctionDataBase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideJunctionDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): JunctionDataBase = Room
        .databaseBuilder(context, JunctionDataBase::class.java, "JunctionDataBase")
        .build()

    @Provides
    fun provideJoticeDao(
        junctionDataBase: JunctionDataBase
    ): JunctionDao = junctionDataBase.junctionDao()
}
