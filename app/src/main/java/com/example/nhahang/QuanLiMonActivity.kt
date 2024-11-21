package com.example.nhahang

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuanLiMonActivity : AppCompatActivity() {
    private lateinit var btnMon : Button
    private lateinit var btnNuoc : Button
    private lateinit var btnThemMon: Button
    private lateinit var btnMon1: Button
    private lateinit var btnMon2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quan_li_mon)
        setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        btnMon = findViewById(R.id.btnMon)
        btnNuoc = findViewById(R.id.btnNuoc)
        btnThemMon = findViewById(R.id.btnThemMon)
        btnMon1 = findViewById(R.id.btnMon1)
        btnMon2 = findViewById(R.id.btnMon2)
    }
    //set event
    fun setEvent(){
        btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
        btnMon.setOnClickListener {
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnNuoc.setOnClickListener {
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnThemMon.setOnClickListener {
            val fmng  = ThemMonFramgent()
            fmng.show(supportFragmentManager,"add form dia log")
        }
        btnMon1.setOnClickListener {
            val fmng  = ChiTietMonFramgent()
            fmng.show(supportFragmentManager,"add form dia log")
        }
        btnMon2.setOnClickListener {
            val fmng  = ChiTietMonFramgent()
            fmng.show(supportFragmentManager,"add form dia log")
        }
    }
}