package com.example.calendar.data.remote.api

import retrofit2.http.GET

interface CalendarAPI {
    @GET("/api/storeCalendarTask")
    suspend fun storeCalendarTask()

    @GET("/api/getCalendarTaskLists")
    suspend fun getCalendarTaskLists()

    @GET("/api/deleteCalendarTask")
    suspend fun deleteCalendarTask()

}