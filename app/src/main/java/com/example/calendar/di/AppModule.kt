package com.example.calendar.di

import com.example.calendar.common.Constants
import com.example.calendar.data.remote.api.TasksAPI
import com.example.calendar.data.repository.TaskRepositoryImp
import com.example.calendar.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideTaskApi(): TasksAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TasksAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTaskRepository(api: TasksAPI): TaskRepository {
        return TaskRepositoryImp(api)
    }
}

private fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}