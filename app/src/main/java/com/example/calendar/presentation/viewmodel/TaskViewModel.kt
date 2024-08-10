package com.example.calendar.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.common.Resource
import com.example.calendar.domain.repository.TaskRepository
import com.example.calendar.presentation.model.Task
import kotlinx.coroutines.launch
import retrofit2.Response

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val tasks: MutableLiveData<Resource<Task>> = MutableLiveData()

    init {
        getAllTasks()
    }
    fun getAllTasks() = viewModelScope.launch {
        tasks.postValue(Resource.Loading())
        val response = repository.getAllTasks()
        tasks.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<Task>): Resource<Task> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(response.body()!!)
            }
        }
        return Resource.Error(response.body(), response.message())
    }
}