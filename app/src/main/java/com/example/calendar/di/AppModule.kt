package com.example.calendar.di

import com.example.calendar.common.Constants
import com.example.calendar.data.remote.api.TasksAPI
import com.example.calendar.data.repository.TaskRepositoryImp
import com.example.calendar.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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