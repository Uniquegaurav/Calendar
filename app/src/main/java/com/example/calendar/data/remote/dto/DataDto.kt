package com.example.calendar.data.remote.dto

import com.example.calendar.domain.model.Data

data class DataDto(val taskId: String, val task: TaskDto)

fun DataDto.toData(): Data {
    return Data(
        taskId = taskId,
        task = task.toTask()
    )
}


