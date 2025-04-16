package com.example.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.database.database.Todo
import com.example.database.databinding.ItemTodoBinding

class TodoAdapter(
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todos: List<Todo> = emptyList()

    fun submitList(list: List<Todo>){
        this.todos = list
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(val bind: ItemTodoBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        val bind = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(bind)
    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind.apply {
            tvTitle.text = todo.title
            cbDone.isChecked = todo.isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}