package com.example.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.database.TodoDatabase
import com.example.database.databinding.FragmentTodoBinding
import com.example.database.repository.TodoRepository

class TodoFragment : Fragment() {
    private lateinit var bind: FragmentTodoBinding
    private lateinit var tvm: TodoViewModel
    lateinit var database: TodoDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false)

        database = TodoDatabase.getDatabase(requireContext())
        val repo = TodoRepository(database)
        tvm = ViewModelProvider(this, TodoViewModelFactory(repo))[TodoViewModel::class.java]

        val adapter = TodoAdapter(tvm)
        bind.rvTodo.adapter = adapter
        bind.rvTodo.layoutManager = LinearLayoutManager(requireContext())

        tvm.todoList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

        bind.btnAdd.setOnClickListener {
            val title = bind.etTodo.text.toString()
            tvm.insertTodo(title, false)
            bind.etTodo.setText("")
            bind.etTodo.clearFocus()
        }
//        context?.deleteDatabase("todoDB")

        return bind.root
    }
}