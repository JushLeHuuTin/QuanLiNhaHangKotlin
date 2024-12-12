package com.example.nhahang

import android.content.Context
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DoiMatKhauActiviy : AppCompatActivity() {
    private lateinit var btnAccept : Button
    private lateinit var edtMatKhauCu: EditText
    private lateinit var edtMatKhauMoi: EditText
    private lateinit var edtNhapLaiMatKhauMoi: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doi_mat_khau_activiy)
        setControl()
        setEvent()
    }
        fun setControl() {
            btnAccept = findViewById(R.id.btnXacNhanDoiMatKhau)
            edtMatKhauCu = findViewById(R.id.edtMatKhauCu)
            edtMatKhauMoi = findViewById(R.id.edtMatKhauMoi)
            edtNhapLaiMatKhauMoi = findViewById(R.id.edtNhapLaiMatKhauMoi)
        }
        fun setEvent() {
            btnAccept.setOnClickListener {
                val oldPasswordInput = edtMatKhauCu.text.toString()
                val newPasswordInput = edtMatKhauMoi.text.toString()
                val confirmPasswordInput = edtNhapLaiMatKhauMoi.text.toString()

                val userList = accountList.userList
                val user = userList.find { it.username == taikhoan.username && it.password == oldPasswordInput }

                if (user != null) {
                    if(edtMatKhauCu.length() != 0) {
                        if(edtMatKhauMoi.length() != 0) {
                            if(edtNhapLaiMatKhauMoi.length() != 0) {
                                if(newPasswordInput == confirmPasswordInput) {
                                    if(oldPasswordInput == taikhoan.password) {
                                        accountList.updatePassword(user.username.toString(), newPasswordInput)
                                        startActivity(Intent(this,TienIchActivity::class.java))
                                        Toast.makeText(this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show()
                                    } else {
                                        Toast.makeText(this, "Nhập khẩu cũ không đúng!", Toast.LENGTH_SHORT).show()
                                    }
                                } else {
                                    Toast.makeText(this, "Nhập khẩu mới không giống nhau!", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(this, "Nhập lại mật khẩu mới không được trống!", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this, "Mật khẩu mới không được trống!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Mật khẩu cũ không được trống!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Sai dữ liệu người dùng!", Toast.LENGTH_SHORT).show()
                }
//                startActivity(Intent(this,TienIchActivity::class.java))
//                Toast.makeText(this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show()
            }
        }
}