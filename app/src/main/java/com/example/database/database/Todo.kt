package com.example.database.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    val title: String,
    val isChecked: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)
