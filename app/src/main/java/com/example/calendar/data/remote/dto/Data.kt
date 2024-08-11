package com.example.calendar.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("tasks") val tasks: List<TaskDto>)