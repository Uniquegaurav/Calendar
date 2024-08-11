package com.example.calendar.domain.model

import com.example.calendar.data.remote.dto.TaskDetailsDto
import com.example.calendar.data.remote.dto.TaskDto

data class Task(val taskId: Int, val task: TaskDetails)

fun Task.toTaskDto(): TaskDto {
    return TaskDto(
        taskId = taskId,
        task = task.toTaskDetailsDto()
    )
}