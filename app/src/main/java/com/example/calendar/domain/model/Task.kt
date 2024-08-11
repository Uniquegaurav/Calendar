package com.example.calendar.domain.model

import com.example.calendar.data.remote.dto.TaskDto

data class Task(
    val id: Int, val title: String, val description: String
)

fun Task.toTaskDto(): TaskDto {
    return TaskDto(
        id = id,
        title = title,
        description = description
    )
}