package com.example.calendar.domain.use_cases

import com.example.calendar.common.Constants
import com.example.calendar.data.remote.request.DeleteCalendarTaskRequest
import com.example.calendar.domain.repository.TaskRepository
import java.lang.Exception
import javax.inject.Inject

class DeleteCalendarTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(taskId: Int): Boolean {
        return try {
            repository.deleteCalendarTask(
                DeleteCalendarTaskRequest(
                    userId = Constants.TEMP_USER_ID,
                    taskId = taskId
                )
            )
            true

        } catch (_: Exception) {
            false
        }

    }
}