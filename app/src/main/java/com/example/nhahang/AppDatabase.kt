package com.example.nhahang

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MonAn::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun monAnDAO():MonAnDAO
}