package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuenMatKhauActivity : AppCompatActivity() {
    private lateinit var edtSDT : EditText
    private lateinit var edtMatKhauMoi : EditText
    private lateinit var edtNhapLaiMatKhauMoi : EditText
    private lateinit var btnXacNhanDoiMatKhau: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quen_mat_khau)
        setControl()
        setEvent()
    }
    fun setControl(){
        edtSDT = findViewById(R.id.edtSDT)
        edtMatKhauMoi = findViewById(R.id.edtMatKhauMoi)
        edtNhapLaiMatKhauMoi = findViewById(R.id.edtNhapLaiMatKhauMoi)
        btnXacNhanDoiMatKhau = findViewById(R.id.btnXacNhanDoiMatKhau)
    }
    fun setEvent(){
        btnXacNhanDoiMatKhau.setOnClickListener{
            val sdt = edtSDT.text.toString()
            val newPasswordInput = edtMatKhauMoi.text.toString()
            val confirmPasswordInput = edtNhapLaiMatKhauMoi.text.toString()
            val userList = accountList.userList
            val user = userList.find { it.sdt == sdt }

            if(edtSDT.length() != 0) {
                if(edtMatKhauMoi.length() != 0) {
                    if(edtNhapLaiMatKhauMoi.length() != 0) {
                        if(newPasswordInput == confirmPasswordInput) {
                            if(user != null) {
                                accountList.updatePassword(user.username.toString(), newPasswordInput)
                                startActivity(Intent(this,LoginActivity::class.java))
                                Toast.makeText(this, "Cập nhật mật khẩu thành công!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Số điện thoại không đúng!", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this, "Mật khẩu mới không trùng nhau!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Nhập lại mật khẩu mới không được trống!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Mật khẩu mới không được trống!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Số điện thoại không được trống!", Toast.LENGTH_SHORT).show()
            }
//            val intent = Intent(this,LoginActivity::class.java)
//            startActivity(intent)
//            Toast.makeText(this, "Cập nhật mật khẩu thành công!", Toast.LENGTH_SHORT).show()
        }
    }
}