package com.example.nhahang
data class BillInfo (
    val idBillInfo: Int,
    val idBill: Int,
    val foodName: String,
    val foodImg: Int,
    var quantity: Int,
    var price: Double
)