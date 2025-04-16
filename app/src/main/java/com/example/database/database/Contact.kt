package com.example.database.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val uniqueId : Long = 0,
    val name : String,
    val phone : String,
    val createdDate: Date
)