package com.example.nhahang

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuanLiMonAcitivity : AppCompatActivity() {
    private lateinit var btnMon : Button
    private lateinit var btnNuoc : Button
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
    }
}