package com.example.calendar.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendar.R
import com.example.calendar.presentation.fragment.CalendarFragment
import com.example.calendar.presentation.fragment.TaskListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CalendarFragment())
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.task_list_container, TaskListFragment())
                .commit()
        }
    }
}