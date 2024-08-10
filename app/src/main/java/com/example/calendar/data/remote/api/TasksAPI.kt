package com.example.calendar.data.remote.api

import com.example.calendar.data.remote.dto.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.dto.GetCalendarTaskListRequest
import com.example.calendar.data.remote.dto.StoreCalendarTaskRequest
import com.example.calendar.presentation.model.Task
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TasksAPI {
    @POST("api/storeCalendarTask")
    suspend fun storeCalendarTask(@Body request: StoreCalendarTaskRequest)

    @POST("api/getCalendarTaskLists")
    suspend fun getCalendarTaskLists(@Body request: GetCalendarTaskListRequest) : Response<Task>

    @POST("api/deleteCalendarTask")
    suspend fun deleteCalendarTask(@Body request: DeleteCalendarTaskRequest)

}