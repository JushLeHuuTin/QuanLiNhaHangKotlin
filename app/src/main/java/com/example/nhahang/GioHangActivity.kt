package com.example.nhahang

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GioHangActivity : AppCompatActivity() {
    private lateinit var tvTableName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gio_hang)
        setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        tvTableName = findViewById(R.id.tv_TableName)
    }
    //set event
    fun setEvent(){
        tvTableName.text = intent.getStringExtra("TableName")
    }
}