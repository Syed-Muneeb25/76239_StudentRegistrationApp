package com.example.a76239_studentregistrationapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao  //fuctions to save and search students
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: Student): Long

    @Query("SELECT * FROM students WHERE studentId = :id LIMIT 1")
    suspend fun findStudent(id: Int): Student?
}