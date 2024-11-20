package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GioHangActivity : AppCompatActivity() {
    private lateinit var btnXacNhan : Button
    private lateinit var btnThemMon : Button
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
        btnXacNhan = findViewById(R.id.btnThanhToan)
        btnThemMon = findViewById(R.id.btnThemMon)
    }
    //set event
    fun setEvent(){
        tvTableName.text = intent.getStringExtra("TableName")
        btnXacNhan.setOnClickListener {
            startActivity(Intent(this,QRThanhToanActivity::class.java))
        }
        btnThemMon.setOnClickListener {
            val intent = Intent(this,GoiMonActivity::class.java)
            intent.putExtra("TableName",tvTableName.text)
            startActivity(intent)
        }
    }
}