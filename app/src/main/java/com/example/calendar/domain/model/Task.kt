package com.example.calendar.domain.model

import com.example.calendar.data.remote.dto.TaskDto

data class Task(val taskId: Int, val taskDetails: TaskDetails?)

fun Task.toTaskDto(): TaskDto {
    return TaskDto(
        taskId = taskId,
        taskDetailsDto = taskDetails?.toTaskDetailsDto()
    )
}