package com.example.calendar.data.repository

import com.example.calendar.data.remote.api.TasksAPI
import com.example.calendar.data.remote.dto.DataDto
import com.example.calendar.data.remote.requestmodel.DeleteCalendarTaskRequest
import com.example.calendar.data.remote.requestmodel.GetCalendarTaskListRequest
import com.example.calendar.data.remote.requestmodel.StoreCalendarTaskRequest
import com.example.calendar.domain.repository.TaskRepository
import javax.inject.Inject


class TaskRepositoryImp @Inject constructor(private val api: TasksAPI) : TaskRepository {
    override suspend fun storeCalendarTask(storeCalendarTaskRequest: StoreCalendarTaskRequest) {
        return api.storeCalendarTask(storeCalendarTaskRequest)
    }

    override suspend fun getCalendarTaskLists(getCalendarTaskListRequest: GetCalendarTaskListRequest): List<DataDto> {
        return api.getCalendarTaskLists(getCalendarTaskListRequest)
    }

    override suspend fun deleteCalendarTask(deleteCalendarTaskRequest: DeleteCalendarTaskRequest) {
        return api.deleteCalendarTask(deleteCalendarTaskRequest)
    }


}