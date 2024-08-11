package com.example.calendar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calendar.domain.use_cases.GenerateCalendarDays
import com.example.calendar.presentation.model.Day
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(private val generateCalendarDays: GenerateCalendarDays) :
    ViewModel() {
    private val calendar: Calendar = Calendar.getInstance()
    var currentMonth: Int
    var currentYear: Int

    init {
        currentMonth = calendar.get(Calendar.MONTH)
        currentYear = calendar.get(Calendar.YEAR)
    }

    fun updateCalendarMonthAndYear(updateCount: Int) {
        currentMonth += updateCount
        if (currentMonth > 11) {
            currentMonth = 0
            currentYear += 1
        } else if (currentMonth < 0) {
            currentMonth = 11
            currentYear -= 1
        }
    }

    fun getCalendarDays(calendarMonth: Int, calendarYear: Int): MutableList<Day> {
        return generateCalendarDays(calendarMonth, calendarYear)
    }
}