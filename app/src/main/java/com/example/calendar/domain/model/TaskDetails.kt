package com.example.calendar.domain.model

import com.example.calendar.data.remote.dto.TaskDetailsDto

data class TaskDetails(
    val date: Int, val title: String, val description: String
)

fun TaskDetails.toTaskDetailsDto(): TaskDetailsDto {
    return TaskDetailsDto(
        date = date,
        title = title,
        description = description
    )
}