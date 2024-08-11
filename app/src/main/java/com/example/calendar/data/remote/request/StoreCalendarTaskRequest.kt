package com.example.calendar.data.remote.request

import com.example.calendar.data.remote.dto.TaskDetailsDto
import com.google.gson.annotations.SerializedName

data class StoreCalendarTaskRequest(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("task") val task: TaskDetailsDto
)
