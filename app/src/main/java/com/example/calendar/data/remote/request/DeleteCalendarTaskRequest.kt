package com.example.calendar.data.remote.request

data class DeleteCalendarTaskRequest(
    val userId: Int,
    val taskId: Int
)