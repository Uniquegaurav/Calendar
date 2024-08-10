package com.example.calendar.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TaskModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String
)