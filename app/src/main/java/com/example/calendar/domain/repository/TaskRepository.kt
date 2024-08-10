package com.example.calendar.domain.repository

import com.example.calendar.data.remote.api.RetrofitTaskAPIClient
import com.example.calendar.data.remote.dto.GetCalendarTaskListRequest
import com.example.calendar.presentation.model.Task
import retrofit2.Response


class TaskRepository {
    suspend fun getAllTasks() : Response<Task> {
        return RetrofitTaskAPIClient.taskClient.getCalendarTaskLists(
            GetCalendarTaskListRequest(1)
        )
    }
}