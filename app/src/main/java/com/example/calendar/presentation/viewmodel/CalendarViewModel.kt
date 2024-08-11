package com.example.calendar.presentation.viewmodel

import android.icu.text.CaseMap.Title
import androidx.lifecycle.ViewModel
import com.example.calendar.domain.use_cases.GenerateCalendarDays
import com.example.calendar.presentation.model.Day
import java.util.Calendar

class CalendarViewModel : ViewModel() {
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
        val generateCalendarDays = GenerateCalendarDays()
        return generateCalendarDays(calendarMonth, calendarYear)
    }

    fun createTaskForDay(day: Day, title: String, descriptionRequestedChangeListener: String) {

    }

}