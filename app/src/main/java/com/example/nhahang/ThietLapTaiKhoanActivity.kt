package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThietLapTaiKhoanActivity : AppCompatActivity() {
    private lateinit var btnLogOut : Button
    private lateinit var btnChangePass : Button
    private lateinit var btnQuenPass : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thiet_lap_tai_khoan)
        setControlAndEvent()
    }
    ///set control && event
    fun setControlAndEvent(){
        btnLogOut = findViewById(R.id.btnDangXuat)
        btnChangePass = findViewById(R.id.btnDoiMatKhau)
        btnQuenPass = findViewById(R.id.btnQuenMatKhau)
        btnLogOut.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        btnChangePass.setOnClickListener {
            startActivity(Intent(this,DoiMatKhauActiviy::class.java))
        }
        btnQuenPass.setOnClickListener {
            startActivity(Intent(this,QuenMatKhauActivity::class.java))
        }

    }

}