package com.example.nhahang

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThongKeMonAnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thong_ke_mon_an)
        val btnQuayLai : Button = findViewById(R.id.btnQuayLai3)
        btnQuayLai.setOnClickListener{
            finish()
        }
    }
}