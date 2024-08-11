package com.example.calendar.data.remote.dto

import android.util.Log
import com.example.calendar.domain.model.TaskDetails

data class TaskDetailsDto(
    val date: Long?,
    val title: String?,
    val description: String?
)

fun TaskDetailsDto.toTaskDetails(): TaskDetails {
    Log.d("each task detail", title.toString())
    return TaskDetails(
        date = date,
        title = title,
        description = description
    )
}