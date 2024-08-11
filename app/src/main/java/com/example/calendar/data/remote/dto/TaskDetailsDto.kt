package com.example.calendar.data.remote.dto

import com.example.calendar.domain.model.TaskDetails
import com.google.gson.annotations.SerializedName

data class TaskDetailsDto(
    @SerializedName("date") val date: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String
)

fun TaskDetailsDto.toTaskDetails(): TaskDetails {
    return TaskDetails(
        date = date,
        title = title,
        description = description
    )
}