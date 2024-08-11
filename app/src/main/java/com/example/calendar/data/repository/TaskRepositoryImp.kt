package com.example.calendar.data.repository

import com.example.calendar.data.remote.api.TasksAPI
import com.example.calendar.data.remote.dto.Data
import com.example.calendar.data.remote.request.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.request.GetCalendarTaskListRequest
import com.example.calendar.data.remote.request.StoreCalendarTaskRequest
import com.example.calendar.domain.repository.TaskRepository
import retrofit2.Response
import javax.inject.Inject


class TaskRepositoryImp @Inject constructor(private val api: TasksAPI) : TaskRepository {
    override suspend fun storeCalendarTask(storeCalendarTaskRequest: StoreCalendarTaskRequest) {
        return api.storeCalendarTask(storeCalendarTaskRequest)
    }

    override suspend fun getCalendarTaskLists(getCalendarTaskListRequest: GetCalendarTaskListRequest): Response<Data> {
        return api.getCalendarTaskLists(getCalendarTaskListRequest)
    }

    override suspend fun deleteCalendarTask(deleteCalendarTaskRequest: DeleteCalendarTaskRequest) {
        return api.deleteCalendarTask(deleteCalendarTaskRequest)
    }


}