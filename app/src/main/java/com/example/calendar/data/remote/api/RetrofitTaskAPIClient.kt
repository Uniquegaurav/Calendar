package com.example.calendar.data.remote.api

import com.example.calendar.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTaskAPIClient {
    companion object {
        val taskClient: TasksAPI by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TasksAPI::class.java)
        }
    }
}