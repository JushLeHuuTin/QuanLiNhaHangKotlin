package com.example.nhahang

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var btnDangNhap : Button
    private lateinit var btnQuenMatKhau : Button
    private lateinit var editUsername : EditText
    private lateinit var editPassword : EditText
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
        editUsername = findViewById(R.id.editUsername)
        editPassword = findViewById(R.id.editPassword)

        val userList = accountList.userList

        btnDangNhap.setOnClickListener {
            val usernameInput = editUsername.text.toString()
            val passwordInput = editPassword.text.toString()
            // tra cứu tài khoản
            val user = userList.find { it.username == usernameInput && it.password == passwordInput }
            if(editUsername.length() != 0 || editPassword.length() != 0) {
                if (user != null) {
                    when (user.quyen) {
                        "admin" -> {
                            Toast.makeText(this, "Chào ${user.ten}", Toast.LENGTH_SHORT).show()
                            // Lưu vào taikhoan tạm thời
                            taikhoan.username = user.username
                            taikhoan.password = user.password
                            taikhoan.ten = user.ten
                            taikhoan.sdt = user.sdt
                            taikhoan.chucVu = user.chucVu
                            taikhoan.quyen = user.quyen
                            startActivity(Intent(this,MainActivity::class.java))
                        }
                        "nhanvien" -> {
                            Toast.makeText(this, "Chào ${user.ten}", Toast.LENGTH_SHORT).show()
                            taikhoan.username = user.username
                            taikhoan.password = user.password
                            taikhoan.ten = user.ten
                            taikhoan.sdt = user.sdt
                            taikhoan.chucVu = user.chucVu
                            taikhoan.quyen = user.quyen
                            startActivity(Intent(this,MainActivity::class.java))
                        }
                        "khachhang" -> {
                            Toast.makeText(this, "Chào ${user.ten}", Toast.LENGTH_SHORT).show()
                            taikhoan.username = user.username
                            taikhoan.password = user.password
                            taikhoan.ten = user.ten
                            taikhoan.sdt = user.sdt
                            taikhoan.chucVu = user.chucVu
                            taikhoan.quyen = user.quyen
                            startActivity(Intent(this,MainActivity::class.java))
                        }
                    }
                } else {
                    Toast.makeText(this, "Tài khoản hoặc mật khẩu không hợp lệ!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập tài khoản và mật khẩu!", Toast.LENGTH_SHORT).show()
            }
        }
        btnQuenMatKhau.setOnClickListener {
            startActivity(Intent(this,QuenMatKhauActivity::class.java))
        }
    }
}