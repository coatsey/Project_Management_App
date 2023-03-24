package com.example.projectmanagement.adapters

import android.content.Context
import android.content.res.Resources
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmanagement.models.Task

open class TaskListItemsAdapter(
    private val context: Context,
    private var list: ArrayList<Task>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    private fun Int.toDP(): Int =
        (this/ Resources.getSystem().displayMetrics.density).toInt()
}