package com.example.nhahang

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "MonAn")
data class MonAn(
     @PrimaryKey(autoGenerate = true) var maMon : Int = 0,
    var tenMon : String, var moTa : String, var giaMon : Int ,  var anh : Int, var danhMuc : String)