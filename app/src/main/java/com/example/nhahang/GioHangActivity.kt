package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale

class GioHangActivity : AppCompatActivity() {
    private lateinit var btnThanhToan : Button
    private lateinit var btnThemMon : Button
    private lateinit var tvTableName : TextView
    private lateinit var btnQuayLai : Button
    private lateinit var lvGioHang : ListView
    private lateinit var tvTongtien : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gio_hang)
        setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        tvTableName = findViewById(R.id.tv_TableName)
        btnThanhToan = findViewById(R.id.btnThanhToan)
        btnThemMon = findViewById(R.id.btnThemMon)
        btnQuayLai = findViewById(R.id.btnQuayLai_GioHang)
        lvGioHang = findViewById(R.id.lvGioHang)
        tvTongtien = findViewById(R.id.tvTongHoaDon)
    }
    //set event
    fun setEvent(){
        tvTableName.text = intent.getStringExtra("TableName")
        btnThanhToan.setOnClickListener {
            startActivity(Intent(this,QRThanhToanActivity::class.java))
        }
        btnThemMon.setOnClickListener {
            val intent = Intent(this,GoiMonActivity::class.java)
            intent.putExtra("TableName",tvTableName.text)
            startActivity(intent)
        }
        btnQuayLai.setOnClickListener {
            finish()
        }
        var ListBillInfo :MutableList<BillInfo> = mutableListOf()
        ListBillInfo.add(BillInfo(1,2,"Món mì ý",R.drawable.img,2,140000.0))
        ListBillInfo.add(BillInfo(1,2,"Món mì Sốt thái",R.drawable.img_1,1,140000.0))
        ListBillInfo.add(BillInfo(1,2,"Món mì xúc xích",R.drawable.img_3,1,100000.0))
        val adapter = GioHangListViewAdapte(this,ListBillInfo)
        lvGioHang.adapter = adapter
        var tongTien : Double = 0.0
        ListBillInfo.forEach{item ->
            tongTien += item.price
        }
        val format = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
        tvTongtien.text = "Tổng tiền: ${format.format(tongTien)}"



   }
}