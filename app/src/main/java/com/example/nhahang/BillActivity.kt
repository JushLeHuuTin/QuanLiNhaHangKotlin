package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BillActivity : AppCompatActivity() {
    private lateinit var btnPrint : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bill)
        btnPrint  = findViewById(R.id.btnPrint)
        btnPrint.setOnClickListener {
            startActivity(Intent(this,KhuVucActivity::class.java))
        }
    }

}