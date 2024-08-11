package com.example.calendar.data.remote.request

import com.google.gson.annotations.SerializedName

data class GetCalendarTaskListRequest(@SerializedName("user_id") val userId: Int)

