package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Calendar

class TienIchActivity : AppCompatActivity() {
    private lateinit var btnCheckOutInt : Button
    private lateinit var tvTen :TextView
    private lateinit var tvChucVu :TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tien_ich)
        btnCheckOutInt = findViewById(R.id.btnCheck)
        tvTen = findViewById(R.id.tvTen)
        tvChucVu = findViewById(R.id.tvChucVu)
        val calendar: Calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val month = calendar[Calendar.MONTH] + 1
        val year = calendar[Calendar.YEAR]
        val timeString = String.format("%02d:%02d %02d/%02d/%04d", hour, minute, day, month, year)
        var check = 0
        btnCheckOutInt.setOnClickListener{
            if(check == 0) {
                btnCheckOutInt.setText("Đã check In lúc: " + timeString)
                check = 1
            } else {
                btnCheckOutInt.setText("Đã check Out lúc: " + timeString)
                check = 0
            }
        }
        if(taikhoan.quyen == "khachhang") {
            btnCheckOutInt.visibility = View.INVISIBLE  // Ẩn button
        } else {
            btnCheckOutInt.visibility = View.VISIBLE
        }

        tvTen.setText(taikhoan.ten)
        tvChucVu.setText(taikhoan.chucVu)
        setEvent()
    }

    fun setEvent(){
        var bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.bottom_nav_extension

        bottomNav.setOnNavigationItemSelectedListener { i ->
            when(i.itemId){
                R.id.bottom_nav_home->{
                    startActivity(Intent(this,MainActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_location->{
                    startActivity(Intent(this,KhuVucActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_chart->{
                    startActivity(Intent(this,ThongKeActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_work->{
                    startActivity(Intent(this,QuanLiActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
              else -> false
            }
        }
        val btnSrtingAccount1 : Button = findViewById(R.id.btnTienIch2)
        val btnSrtingAccount2 : Button = findViewById(R.id.btnTienIch3)
        val btnSetting : Button = findViewById(R.id.btn_setting)
        btnSetting.setOnClickListener {
            startActivity(Intent(this,ThietLapTaiKhoanActivity::class.java))
        }
        btnSrtingAccount1.setOnClickListener {
            startActivity(Intent(this,ThietLapTaiKhoanActivity::class.java))
        }
        btnSrtingAccount2.setOnClickListener {
            startActivity(Intent(this,ThietLapTaiKhoanActivity::class.java))
        }
    }

}