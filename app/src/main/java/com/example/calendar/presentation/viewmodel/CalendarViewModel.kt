package com.example.calendar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calendar.domain.use_cases.GenerateCalendarDays
import com.example.calendar.presentation.model.Day
import java.util.Calendar

class CalendarViewModel : ViewModel() {
    var calendar: Calendar = Calendar.getInstance()
    var currentMonth : Int
    var currentYear: Int
    init {
        currentMonth = calendar.get(Calendar.DAY_OF_MONTH) -1
        currentYear = calendar.get(Calendar.YEAR)
    }

    fun updateCalendarMonthAndYear(updateCount: Int) {
        currentMonth += updateCount
        if (currentMonth > 11) {
            currentYear += 1
            currentMonth = 0
        } else if (currentMonth < 0) {
            currentYear -= 1
            currentMonth = 11
        }
    }

    fun getCalendarDays(calendarMonth: Int, calendarYear: Int): MutableList<Day> {
        val generateCalendarDays = GenerateCalendarDays()
        return generateCalendarDays(calendarMonth, calendarYear)
    }

}