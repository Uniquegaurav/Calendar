package com.example.calendar.data.remote.dto

data class StoreCalendarTaskRequest(
    val userId: Int,
    val task: TaskModel
)

data class GetCalendarTaskListRequest(
    val userId: Int
)

data class GetCalendarTaskListResponse(
    val taskDetails: List<TaskDetail>
)

data class TaskDetail(
    val taskId: Int,
    val task: TaskModel
)

data class DeleteCalendarTaskRequest(
    val userId: Int,
    val taskId: Int
)
