package com.example.calendar.presentation.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.calendar.R
import com.example.calendar.common.Constants
import com.example.calendar.databinding.DialogTaskBinding
import com.example.calendar.databinding.FragmentCalendarBinding
import com.example.calendar.presentation.adapter.CalendarAdapter
import com.example.calendar.presentation.mapper.Mapper
import com.example.calendar.presentation.model.Day
import com.example.calendar.presentation.viewmodel.CalendarViewModel

class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var calendarViewModel: CalendarViewModel
    private lateinit var binding: FragmentCalendarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarViewModel = ViewModelProvider(requireActivity())[CalendarViewModel::class.java]
        setUpRecyclerView()
        updateCalendar()
        setListeners()
    }

    private fun setListeners() {
        binding.prevMonthButton.setOnClickListener {
            calendarViewModel.updateCalendarMonthAndYear(updateCount = -1)
            updateCalendar()
        }
        binding.nextMonthButton.setOnClickListener {
            calendarViewModel.updateCalendarMonthAndYear(updateCount = 1)
            updateCalendar()

        }
        calendarAdapter.setOnItemClickListener {
            if (it.day.isNotEmpty())
                showAlertDialog(it)
        }
    }

    private fun showAlertDialog(day: Day) {
        val dialogViewBinding = DialogTaskBinding.inflate(LayoutInflater.from(requireContext()))
        AlertDialog.Builder(requireContext()).apply {
            setTitle(R.string.dialog_title)
            setMessage(getString(R.string.dialog_message, day.day))
            setView(dialogViewBinding.root)
            setPositiveButton(R.string.create_task) { dialog, _ ->
                val title = dialogViewBinding.taskTitle.text.toString()
                val description = dialogViewBinding.taskDescription.text.toString()
//                calendarViewModel.createTaskForDay(day, title, description)
                dialog.dismiss()
            }
            setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            create().show()
        }
    }

    private fun updateCalendar() {
        binding.currentMonth.text = Mapper.monthToString(calendarViewModel.currentMonth)
        binding.currentYear.text = calendarViewModel.currentYear.toString()
        calendarAdapter.differ.submitList(
            calendarViewModel.getCalendarDays(
                calendarViewModel.currentMonth,
                calendarViewModel.currentYear
            )
        )
    }

    private fun setUpRecyclerView() {
        calendarAdapter = CalendarAdapter()
        binding.recyclerView.apply {
            adapter = calendarAdapter
            layoutManager = GridLayoutManager(requireContext(), Constants.MONTH_COUNT)
            itemAnimator = null
        }
    }

}