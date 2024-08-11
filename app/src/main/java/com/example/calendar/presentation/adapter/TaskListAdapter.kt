package com.example.calendar.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.databinding.ItemTaskBinding
import com.example.calendar.domain.model.Task

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TaskListAdapter.TaskViewHolder, position: Int) {
        val taskItem = differ.currentList[position]
        holder.binding.apply {
            taskDate.text =
                (taskItem.taskDetails?.date ?: "Unknown Date").toString()
            taskDescription.text = taskItem.taskDetails?.description ?: "No Description"
            deleteButton.setOnClickListener {
                onDeleteClickListener?.invoke(taskItem)
            }
        }
    }


    private var onDeleteClickListener: ((Task) -> Unit)? = null
    fun setOnItemDeleteClickListener(listener: (Task) -> Unit) {
        onDeleteClickListener = listener
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.taskId == newItem.taskId
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallBack)
}