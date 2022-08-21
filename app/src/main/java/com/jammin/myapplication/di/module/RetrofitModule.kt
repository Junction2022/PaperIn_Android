package com.jammin.myapplication.di.module

import android.util.Log
import com.jammin.myapplication.data.network.AuthAPI
import com.jammin.myapplication.data.network.CommentAPI
import com.jammin.myapplication.data.network.ThesisAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private val BASE_URL = "http://172.20.10.3:3000/v1/" // TODO("base url 입력")

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthAPI =
        retrofit.create(AuthAPI::class.java)

    @Provides
    fun provideThesisApi(retrofit: Retrofit): ThesisAPI =
        retrofit.create(ThesisAPI::class.java)

    @Provides
    fun provideCommentApi(retrofit: Retrofit): CommentAPI =
        retrofit.create(CommentAPI::class.java)
}
