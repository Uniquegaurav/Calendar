package com.example.calendar.domain.use_cases

import com.example.calendar.presentation.model.Day
import java.util.Calendar

class GenerateCalendarDays() {
    operator fun invoke(month: Int, year: Int): MutableList<Day> {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, 1)

        val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val daysInCalendar = 42
        val calendarList = mutableListOf<Day>()

        for (i in 0 until daysInCalendar) {
            if (i < firstDayOfMonth || i >= firstDayOfMonth + daysInMonth) {
                calendarList.add(Day(""))
            } else {

                val dayOfMonth = i - firstDayOfMonth + 1
                calendarList.add(Day(dayOfMonth.toString()))
            }
        }

        return calendarList
    }

}