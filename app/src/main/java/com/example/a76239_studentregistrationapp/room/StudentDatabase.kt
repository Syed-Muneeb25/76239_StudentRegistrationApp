package com.example.a76239_studentregistrationapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)
abstract class StudentDatabase : RoomDatabase() {  //Room database for storing records
    abstract fun studentDao(): StudentDao
}