package com.example.calendar.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar.R
import com.example.calendar.common.Resource
import com.example.calendar.databinding.FragmentTasksBinding
import com.example.calendar.domain.repository.TaskRepository
import com.example.calendar.presentation.adapter.TaskListAdapter
import com.example.calendar.presentation.model.Task
import com.example.calendar.presentation.viewmodel.TaskViewModel
import com.example.calendar.presentation.viewmodel.TaskViewModelProviderFactory
import retrofit2.Response

class TaskListFragment : Fragment(R.layout.fragment_tasks) {

    private lateinit var taskAdapter: TaskListAdapter
    private lateinit var binding: FragmentTasksBinding
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        taskViewModel = ViewModelProvider(
            requireActivity(),
            TaskViewModelProviderFactory(TaskRepository())
        )[TaskViewModel::class.java]
        dummyTaskForTesting()


//        taskViewModel.tasks.observe(viewLifecycleOwner) { response ->
//            when (response) {
//                is Resource.Error -> {
//                    response.errorMessage?.let {
//                        Log.e("tag", it)
//                    }
//                }
//                is Resource.Loading -> {
//
//                }
//
//                is Resource.Success -> {
//                    response.data?.let {
//                        taskAdapter.differ.submitList(it)
//                    }
//                }
//            }
//        }
    }

    private fun setUpRecyclerView() {
        taskAdapter = TaskListAdapter()
        binding.taskRecyclerView.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun dummyTaskForTesting() {

        var taskList = mutableListOf<Task>()
        taskList.add(Task("1", date = "August 24", "submission task"))
        taskList.add(Task("2", date = "September 23", "task2"))
        taskList.add(Task("3", date = "August 31", "task3"))
        taskAdapter.differ.submitList(taskList)
    }
}