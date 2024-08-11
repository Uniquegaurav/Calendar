package com.example.calendar.data.remote.requestmodel

data class DeleteCalendarTaskRequest(
    val userId: Int,
    val taskId: Int
)