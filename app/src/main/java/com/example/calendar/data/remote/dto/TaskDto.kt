package com.example.calendar.data.remote.dto

import com.example.calendar.domain.model.Task
import com.google.gson.annotations.SerializedName

data class TaskDto(
    @SerializedName("task_id") val taskId: Int,
    @SerializedName("task_detail") val task: TaskDetailsDto
)

fun TaskDto.toTask(): Task {
    return Task(
        taskId = taskId,
        task = task.toTaskDetails()
    )
}


