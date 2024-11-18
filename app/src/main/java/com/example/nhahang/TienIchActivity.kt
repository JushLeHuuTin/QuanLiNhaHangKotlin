package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TienIchActivity : AppCompatActivity() {
    private lateinit var btnCheckOutInt : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tien_ich)

        btnCheckOutInt = findViewById(R.id.btnCheck)
        var check = 0
        btnCheckOutInt.setOnClickListener {
            if(check == 0){
                btnCheckOutInt.setText("Đã CheckIn")
                check  = 1
            }else{
                btnCheckOutInt.setText("Đã CheckOut")
                check = 0
            }
        }

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
              else -> false
            }
        }
        val btnSetting : Button = findViewById(R.id.btn_setting)
        btnSetting.setOnClickListener {
            startActivity(Intent(this,ThietLapTaiKhoanActivity::class.java))
        }
    }

}