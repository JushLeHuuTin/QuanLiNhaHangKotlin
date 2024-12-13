package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale

class XacNhanThemMonActivity : AppCompatActivity() {
    private lateinit var btnSubmit : Button
    private lateinit var tvTableName : TextView
    private lateinit var lv_ThemMon : ListView
    private lateinit var tvTongTien : TextView
    private lateinit var ListBillInfo : MutableList<BillInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_xac_nhan_goi_mon)
        setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        btnSubmit = findViewById(R.id.btnSubmit)
        tvTableName = findViewById(R.id.tv_TableName)
        lv_ThemMon = findViewById(R.id.lv_ThemMon)
        tvTongTien = findViewById(R.id.tvTongtien)
    }
    fun setEvent(){
        tvTableName.text = intent.getStringExtra("TableName")
        btnSubmit.setOnClickListener {
            startActivity(Intent(this,KhuVucActivity::class.java))

        }
//        ListBillInfo.clear()
        ListBillInfo  = mutableListOf()

        ListBillInfo.add(BillInfo(1,2,"Món mì ý",R.drawable.img,3,140000.0))
        ListBillInfo.add(BillInfo(1,2,"Món mì Sốt thái",R.drawable.img_1,1,140000.0))
        ListBillInfo.add(BillInfo(1,2,"pessi",R.drawable.img_4,2,20000.0))
        ListBillInfo.add(BillInfo(1,2,"Spageti",R.drawable.img_2,1,140000.0))
        val adapter = DatMonAdapter(this,ListBillInfo,tvTongTien)
        lv_ThemMon.adapter = adapter
        loadTongTien(ListBillInfo);

    }
    fun loadTongTien(ListBillInfo : List<BillInfo>){
        var tongTien  = 0.0
        ListBillInfo.forEach{item ->
            tongTien += item.price
        }
        val format = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
        tvTongTien.text = "Tổng tiền: ${format.format(tongTien)}"
    }

}