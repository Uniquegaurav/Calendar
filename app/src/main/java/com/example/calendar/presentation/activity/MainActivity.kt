package com.example.calendar.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendar.R
import com.example.calendar.presentation.fragment.CalendarFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CalendarFragment())
        }
    }
}