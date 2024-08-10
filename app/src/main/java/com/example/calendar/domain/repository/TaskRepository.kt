package com.example.calendar.domain.repository

import com.example.calendar.presentation.model.Task
import retrofit2.Response

interface TaskRepository {
    fun getAllTasks() : Response<Task>
}