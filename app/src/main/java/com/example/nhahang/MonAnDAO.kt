package com.example.nhahang

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update

@Dao
interface MonAnDAO {
    @Insert
     fun InsertMonAn(monAn: MonAn)

    @Update
     fun updateMonAn(monAn: MonAn)

    @Delete
     fun deleteMonAn(monAn: MonAn)

    @Query("SELECT * FROM MonAn")
     fun getAllMons(): List<MonAn>

    @Query("SELECT * FROM MonAn WHERE danhMuc = 'Món ăn'")
    fun getAllMonAns(): List<MonAn>

    @Query("SELECT * FROM MonAn WHERE danhMuc = 'Nước'")
    fun getAllNuocs(): List<MonAn>
}