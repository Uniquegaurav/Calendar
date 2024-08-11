package com.example.calendar.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.common.Resource
import com.example.calendar.domain.model.Task
import com.example.calendar.domain.use_cases.DeleteCalendarTaskUseCase
import com.example.calendar.domain.use_cases.GetCalendarTaskUseCase
import com.example.calendar.domain.use_cases.StoreCalendarTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getCalendarTaskUseCase: GetCalendarTaskUseCase,
    private val storeCalendarTaskUseCase: StoreCalendarTaskUseCase,
    private val deleteCalendarTaskUseCase: DeleteCalendarTaskUseCase
) : ViewModel() {

    val tasks: MutableLiveData<Resource<List<Task>>> = MutableLiveData()

    init {
        getAllTasks()
    }

    private fun getAllTasks() = viewModelScope.launch {
        tasks.postValue(Resource.Loading())
        val response = getCalendarTaskUseCase()
        tasks.postValue(response)
    }

    fun addTask(task: Task) = viewModelScope.launch {
        tasks.postValue(Resource.Loading())
        storeCalendarTaskUseCase(task)
    }

    fun deleteTask(taskId: Int) = viewModelScope.launch {
        deleteCalendarTaskUseCase(taskId)
    }

}