package com.example.calendar.data.repository

import com.example.calendar.domain.repository.TaskRepository
import com.example.calendar.presentation.model.Task
import retrofit2.Response


// Not using this approach because of time constraints
//class TaskRepositoryImp : TaskRepository {
//    override fun getAllTasks(): Response<Task> {
//        return Response.success(Task(date = "343",id ="df", description = ""))
//    }
//}