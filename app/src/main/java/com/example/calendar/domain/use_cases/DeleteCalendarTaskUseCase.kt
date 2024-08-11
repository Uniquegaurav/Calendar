package com.example.calendar.domain.use_cases

import com.example.calendar.data.remote.request.DeleteCalendarTaskRequest
import com.example.calendar.domain.repository.TaskRepository
import javax.inject.Inject

class DeleteCalendarTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(taskId: Int) {
        repository.deleteCalendarTask(
            DeleteCalendarTaskRequest(
                userId = 1,
                taskId = taskId
            )
        )
    }
}