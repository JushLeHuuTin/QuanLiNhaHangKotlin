package com.example.nhahang
// Lưu trữ thông tin người dùng tạm thời
data class account(
    var username: String? = null,
    var password: String? = null,
    var ten: String? = null,
    var sdt: String? = null,
    val chucVu: String? = null,
    val quyen: String? = null
)

