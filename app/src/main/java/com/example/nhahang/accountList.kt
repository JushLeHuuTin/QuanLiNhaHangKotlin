package com.example.nhahang

object accountList {
    val userList: MutableList<account> = mutableListOf(
        account("admin", "123", "J97", "012345", "admin", "admin"),
        account("nhanvien1", "1234", "Nguyễn Văn A", "0123456", "Phục vụ", "nhanvien"),
        account("khachhang1", "abcd", "Võ Văn Thuận", "01234567", "Khách hàng", "khachhang")
    )

    // Phương thức để cập nhật mật khẩu
    fun updatePassword(username: String, newPassword: String) {
        val user = userList.find { it.username == username }
        if (user != null) {
            user.password = newPassword
        }
    }
}

