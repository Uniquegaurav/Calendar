package com.example.calendar.domain.use_cases
import com.example.calendar.common.Resource
import com.example.calendar.data.remote.dto.toTask
import com.example.calendar.data.remote.request.GetCalendarTaskListRequest
import com.example.calendar.domain.model.Task
import com.example.calendar.domain.repository.TaskRepository
import java.lang.Exception
import javax.inject.Inject
import kotlin.random.Random

class GetCalendarTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(): Resource<List<Task>> {

        try {
            val response = repository.getCalendarTaskLists(
                GetCalendarTaskListRequest(
                    userId = Random.nextInt(),
                )
            )
            return if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!.map { it.task.toTask() })
            } else {
                Resource.Error(
                    message = response.message()
                        ?: "Couldn't fetch the data from the server!"
                )
            }

        }
        catch (e: Exception) {
            return Resource.Error(
                message = e.localizedMessage
                    ?: "Couldn't reach server. Check your internet connection."
            )
        }
    }
}