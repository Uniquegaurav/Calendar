package com.example.calendar.data.remote.api

import com.example.calendar.data.remote.dto.DataDto
import com.example.calendar.data.remote.requestmodel.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.requestmodel.GetCalendarTaskListRequest
import com.example.calendar.data.remote.requestmodel.StoreCalendarTaskRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface TasksAPI {
    @POST("api/storeCalendarTask")
    suspend fun storeCalendarTask(@Body request: StoreCalendarTaskRequest)

    @POST("api/getCalendarTaskLists")
    suspend fun getCalendarTaskLists(@Body request: GetCalendarTaskListRequest): List<DataDto>

    @POST("api/deleteCalendarTask")
    suspend fun deleteCalendarTask(@Body request: DeleteCalendarTaskRequest)

}