package com.example.calendar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calendar.domain.use_cases.GenerateCalendarDays
import com.example.calendar.presentation.model.Day

class CalendarViewModel : ViewModel() {

    fun getCalendarDays(): MutableList<Day> {
        val generateCalendarDays = GenerateCalendarDays()
        return generateCalendarDays(1, 2024)
    }
}