package com.example.database.data

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()

    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }
}