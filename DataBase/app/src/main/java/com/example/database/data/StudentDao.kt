package com.example.database.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Student>>

}