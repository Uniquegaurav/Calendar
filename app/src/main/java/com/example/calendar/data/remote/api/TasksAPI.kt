package com.example.calendar.data.remote.api

import com.example.calendar.data.remote.dto.Data
import com.example.calendar.data.remote.dto.TaskDto
import com.example.calendar.data.remote.request.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.request.GetCalendarTaskListRequest
import com.example.calendar.data.remote.request.StoreCalendarTaskRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TasksAPI {
    @POST("api/storeCalendarTask")
    suspend fun storeCalendarTask(@Body request: StoreCalendarTaskRequest)

    @POST("api/getCalendarTaskLists")
    suspend fun getCalendarTaskLists(@Body request: GetCalendarTaskListRequest): Response<Data>

    @POST("api/deleteCalendarTask")
    suspend fun deleteCalendarTask(@Body request: DeleteCalendarTaskRequest)

}