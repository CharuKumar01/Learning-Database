package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class Contact(
    val name : String,
    val phone : String,
    val createdDate: Date,
    @PrimaryKey(autoGenerate = true)
    val uniqueId : Long = 0
)