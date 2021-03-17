package com.example.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Создать базу данных студентов (Имя, вес, рост, возраст - сгенерировать случайно).
// Вывести из базы данных все записи, отсортированные по возрасту, в таблицу (TableLayout).

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val weight: String,
    val growth: String,
    val age: Int
)