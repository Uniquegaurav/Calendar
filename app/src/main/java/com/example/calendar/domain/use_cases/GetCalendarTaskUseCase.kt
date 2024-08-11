package com.example.calendar.domain.use_cases

import android.util.Log
import com.example.calendar.common.Constants
import com.example.calendar.common.Resource
import com.example.calendar.data.remote.api.TasksAPI
import com.example.calendar.data.remote.dto.toTask
import com.example.calendar.data.remote.request.GetCalendarTaskListRequest
import com.example.calendar.domain.model.Task
import com.example.calendar.domain.model.TaskDetails
import com.example.calendar.domain.repository.TaskRepository
import java.lang.Exception
import javax.inject.Inject

class GetCalendarTaskUseCase @Inject constructor(
    private val repository: TaskRepository,
    private val api: TasksAPI
) {
    suspend operator fun invoke(): Resource<List<Task>> {

        try {
            val response = repository.getCalendarTaskLists(
                GetCalendarTaskListRequest(
                    userId = Constants.TEMP_USER_ID,
                )
            )
            return if (response.isSuccessful && response.body() != null) {
                val tasks = response.body()!!.tasks
                Resource.Success(tasks.map { it.toTask() })

            } else {
                Resource.Error(
                    message = response.message()
                        ?: "Couldn't fetch the data from the server!"
                )
            }

        } catch (e: Exception) {
            Log.e("error here", e.toString())
            return Resource.Error(
                message = e.localizedMessage
                    ?: "Couldn't reach server. Check your internet connection."
            )
        }
    }
}