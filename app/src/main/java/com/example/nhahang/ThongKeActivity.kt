package com.example.nhahang

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThongKeActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var btnDoanhThu : Button
    private lateinit var btnSoLuongBanDat : Button
    private lateinit var btnThongKeMonAn : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thong_ke)

        setControl()

        setEventBtn()

        setEventNav()

    }
    //set control
    fun setControl(){
        bottomNav = findViewById(R.id.bottom_nav_view)
        btnThongKeMonAn = findViewById(R.id.btnSTTMA)
        btnDoanhThu = findViewById(R.id.btnDT)
        btnSoLuongBanDat = findViewById(R.id.btnSLDB)
    }
    fun setEventBtn(){
        btnThongKeMonAn.setOnClickListener {
            startActivity(Intent(this,ThongKeMonAnActivity::class.java))
        }
        btnDoanhThu.setOnClickListener {
            startActivity(Intent(this,DoanhThuActivity::class.java))
        }
        btnSoLuongBanDat.setOnClickListener {
            startActivity(Intent(this,SoLuongBanDatActivity::class.java))
        }
    }
    //set event bottom nav
    fun setEventNav(){
        bottomNav = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.bottom_nav_home
        bottomNav.setOnNavigationItemSelectedListener { i ->
            when(i.itemId){
                R.id.bottom_nav_home->{
                    startActivity(Intent(this,MainActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_chart->{
                    if(taikhoan.quyen == "admin") {
                        startActivity(Intent(this,ThongKeActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    }
                    true
                }
                R.id.bottom_nav_location->{
                    startActivity(Intent(this,KhuVucActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_work->{
                    if(taikhoan.quyen == "admin") {
                        startActivity(Intent(this,QuanLiActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    }
                    false
                }
                R.id.bottom_nav_extension->{
                    startActivity(Intent(this,TienIchActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }else -> false
            }
        }
    }

}