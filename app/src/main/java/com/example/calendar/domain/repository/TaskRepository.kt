package com.example.calendar.domain.repository

import com.example.calendar.data.remote.dto.DataDto
import com.example.calendar.data.remote.request.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.request.GetCalendarTaskListRequest
import com.example.calendar.data.remote.request.StoreCalendarTaskRequest
import retrofit2.Response


interface TaskRepository {
    suspend fun storeCalendarTask(storeCalendarTaskRequest: StoreCalendarTaskRequest)
    suspend fun getCalendarTaskLists(getCalendarTaskListRequest: GetCalendarTaskListRequest): Response<List<DataDto>>
    suspend fun deleteCalendarTask(deleteCalendarTaskRequest: DeleteCalendarTaskRequest)
}