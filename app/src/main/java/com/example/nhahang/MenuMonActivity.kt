package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuMonActivity : AppCompatActivity() {
    private lateinit var btnMon : Button
    private lateinit var btnNuoc : Button
    private lateinit var lv : ListView
    private lateinit var itemsMonAn : MutableList<Int>
    private lateinit var itemsNuoc : MutableList<Int>
    private lateinit var btnQuanliMon : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_mon)

    }
    fun setControll(){
        lv = findViewById(R.id.lv_GoiMon)
        itemsMonAn = mutableListOf()
        itemsNuoc = mutableListOf()
        btnMon = findViewById(R.id.btnMon)
        btnNuoc = findViewById(R.id.btnNuoc)
        btnQuanliMon = findViewById(R.id.btnQuanliMon)
    }
    fun setEventt(){
        itemsMonAn.add(R.drawable.img)
        itemsMonAn.add(R.drawable.img_1)
        itemsMonAn.add(R.drawable.img_2)
        itemsMonAn.add(R.drawable.img_3)
        itemsNuoc.add(R.drawable.img_4)
        itemsNuoc.add(R.drawable.img_5)
        itemsNuoc.add(R.drawable.img_6)
        itemsNuoc.add(R.drawable.img_7)
        var adapter = ListViewMonAdapter(this,itemsMonAn)
        lv.adapter = adapter

        btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
        btnMon.setOnClickListener {
            adapter = ListViewMonAdapter(this,itemsMonAn)
            lv.adapter = adapter
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnNuoc.setOnClickListener {
            adapter = ListViewMonAdapter(this,itemsNuoc)
            lv.adapter = adapter
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnQuanliMon.setOnClickListener {
            startActivity(Intent(this,QuanLiMonActivity::class.java))
        }
    }

}