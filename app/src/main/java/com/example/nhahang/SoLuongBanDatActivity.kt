package com.example.nhahang

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SoLuongBanDatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_so_luong_ban_dat)
        val btnQuayLai : Button = findViewById(R.id.btnQuayLai2)
        btnQuayLai.setOnClickListener{
            finish()
        }
    }
}