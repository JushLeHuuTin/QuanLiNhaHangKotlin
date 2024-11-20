package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class XacNhanThemMonActivity : AppCompatActivity() {
    private lateinit var btnSubmit : Button
    private lateinit var tvTableName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_xac_nhan_goi_mon)
        setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        btnSubmit = findViewById(R.id.btnSubmit)
        tvTableName = findViewById(R.id.tv_TableName)
    }
    fun setEvent(){
        tvTableName.text = intent.getStringExtra("TableName")
        btnSubmit.setOnClickListener {
            startActivity(Intent(this,KhuVucActivity::class.java))
        }
    }
}