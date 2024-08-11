package com.example.calendar.data.remote.dto

import com.example.calendar.domain.model.Task

data class TaskDto(
    val id: Int, val title: String, val description: String
)

fun TaskDto.toTask(): Task {
    return Task(
        id = id,
        title = title,
        description = description
    )
}