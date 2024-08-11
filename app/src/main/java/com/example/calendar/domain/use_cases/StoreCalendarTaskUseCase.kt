package com.example.calendar.domain.use_cases

import com.example.calendar.common.Constants
import com.example.calendar.data.remote.request.StoreCalendarTaskRequest
import com.example.calendar.domain.model.Task
import com.example.calendar.domain.model.toTaskDto
import com.example.calendar.domain.repository.TaskRepository
import javax.inject.Inject

class StoreCalendarTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.storeCalendarTask(
            StoreCalendarTaskRequest(
                userId = Constants.TEMP_USER_ID,
                task = task.toTaskDto()
            )
        )
    }
}