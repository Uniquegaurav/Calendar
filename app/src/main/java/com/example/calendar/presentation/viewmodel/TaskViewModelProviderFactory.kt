package com.example.calendar.presentation.viewmodel

import com.example.calendar.domain.repository.TaskRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TaskViewModelProviderFactory(private val repository: TaskRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(repository) as T
    }
}