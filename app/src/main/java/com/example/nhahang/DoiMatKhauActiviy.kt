package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DoiMatKhauActiviy : AppCompatActivity() {
    private lateinit var btnAccept : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doi_mat_khau_activiy)
        btnAccept = findViewById(R.id.btnXacNhanDoiMatKhau)
        btnAccept.setOnClickListener {
            startActivity(Intent(this,TienIchActivity::class.java))
        }
    }

}