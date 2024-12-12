package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class QuanLiActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var btnQuanLi : Button
    private lateinit var btnBaoCao : Button
    private lateinit var btnBHXH : Button
    private lateinit var lo_QLBep : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quan_li)
        setControl()
        setEvent()
    }
    fun setControl(){
        btnQuanLi = findViewById(R.id.btnQuanLi)
        btnBHXH = findViewById(R.id.btnBHXH)
        btnBaoCao = findViewById(R.id.btnBaoCao)
        lo_QLBep = findViewById(R.id.lo_QLBep)
    }
    fun setEvent(){
        bottomNav = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.bottom_nav_work
        bottomNav.setOnNavigationItemSelectedListener { i ->
            when(i.itemId){
                R.id.bottom_nav_home->{
                    startActivity(Intent(this,MainActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_chart->{
                    startActivity(Intent(this,ThongKeActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_location->{
                    startActivity(Intent(this,KhuVucActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_extension->{
                    startActivity(Intent(this,TienIchActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }else -> false
            }
        }
        btnQuanLi.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
        btnQuanLi.setOnClickListener {
            btnQuanLi.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnBHXH.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
            btnBaoCao.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnBHXH.setOnClickListener {
            btnBHXH.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnQuanLi.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
            btnBaoCao.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnBaoCao.setOnClickListener {
            btnBaoCao.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnBHXH.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
            btnQuanLi.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        lo_QLBep.setOnClickListener{
            startActivity(Intent(this,QuanLiMonActivity::class.java))
        }
    }

}