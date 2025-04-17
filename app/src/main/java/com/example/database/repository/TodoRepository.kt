package com.example.database.repository

import com.example.database.database.Todo
import com.example.database.database.TodoDatabase

class TodoRepository(val database: TodoDatabase) {
    suspend fun insertTodo(title: String, isChecked: Boolean){
        database.todoDao().insertTodo(Todo(title, isChecked))
    }

    fun getTodos() = database.todoDao().getTodos()

    suspend fun deleteTodo(todo: Todo) = database.todoDao().deleteTodo(todo)
}