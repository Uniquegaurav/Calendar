package com.example.calendar.domain.repository

import com.example.calendar.data.remote.dto.DataDto
import com.example.calendar.data.remote.requestmodel.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.requestmodel.GetCalendarTaskListRequest
import com.example.calendar.data.remote.requestmodel.StoreCalendarTaskRequest


interface TaskRepository {
    suspend fun storeCalendarTask(storeCalendarTaskRequest: StoreCalendarTaskRequest)
    suspend fun getCalendarTaskLists(getCalendarTaskListRequest: GetCalendarTaskListRequest): List<DataDto>
    suspend fun deleteCalendarTask(deleteCalendarTaskRequest: DeleteCalendarTaskRequest)
}