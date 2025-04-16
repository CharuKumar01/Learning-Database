package com.example.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val repo: TodoRepository) : ViewModel() {
    val todoList = repo.getTodos()

    fun insertTodo(title: String, isChecked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertTodo(title, isChecked)
        }
    }
}