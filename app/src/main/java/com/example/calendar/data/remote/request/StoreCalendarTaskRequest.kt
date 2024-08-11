package com.example.calendar.data.remote.request
import com.example.calendar.data.remote.dto.TaskDto

data class StoreCalendarTaskRequest(
    val userId: Int,
    val task: TaskDto
)