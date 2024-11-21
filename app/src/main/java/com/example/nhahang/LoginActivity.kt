package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var btnDangNhap : Button
    private lateinit var btnQuenMatKhau : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        setControlAndEvent()
    }
    //set control and event
    fun setControlAndEvent(){
        btnDangNhap = findViewById(R.id.btnDangNhap)
        btnQuenMatKhau = findViewById(R.id.btnQuenMatKhau_Login)
        btnDangNhap.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        btnQuenMatKhau.setOnClickListener {
            startActivity(Intent(this,QuenMatKhauActivity::class.java))
        }
    }
}