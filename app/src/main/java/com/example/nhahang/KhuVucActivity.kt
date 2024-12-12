package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class KhuVucActivity : AppCompatActivity() {
    private lateinit var recyclerTable : RecyclerView
    private lateinit var tableFloor1 : MutableList<ItemTable>
    private lateinit var tableFloor2 : MutableList<ItemTable>
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var btnTang1 : Button
    private lateinit var btnTang2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_khu_vuc)
        setControl()
        getTable()
        setEvent()
    }
//    set control
    fun setControl(){
        recyclerTable = findViewById(R.id.recyclerTable)

        tableFloor1 = mutableListOf()
        for(i in 1..15){
            if( i % 5 == 0){
                tableFloor1.add(ItemTable("Bàn " + i,1))
            }
            else tableFloor1.add(ItemTable("Bàn " + i,0))
        }
        tableFloor2 = mutableListOf()
        for(i in 1..8){
            if( i % 4 == 0){
                tableFloor2.add(ItemTable("Bàn " + i,1))
            }
            else tableFloor2.add(ItemTable("Bàn " + i,0))
        }
        bottomNav = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.bottom_nav_location
        btnTang1 = findViewById(R.id.btnTang1)
        btnTang2 = findViewById(R.id.btnTang2)
    }
    //get list table
    fun getTable(){
        val layOutManager = GridLayoutManager(this,3)
        recyclerTable.layoutManager = layOutManager
        val adapter = RecyclerTableAdapter(this,tableFloor1)
        recyclerTable.adapter = adapter

    }
    //get event select tang
    fun setEvent(){
        btnTang1.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
        btnTang2.setOnClickListener {
            btnTang2.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnTang1.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
            val adapter = RecyclerTableAdapter(this,tableFloor2)
            recyclerTable.adapter = adapter

        }
        btnTang1.setOnClickListener {
            val adapter = RecyclerTableAdapter(this,tableFloor1)
            recyclerTable.adapter = adapter
            btnTang1.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnTang2.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        bottomNav.setOnNavigationItemSelectedListener { i ->
                when(i.itemId){
                    R.id.bottom_nav_home->{
                        startActivity(Intent(this,MainActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity,R.anim.animation_activity)
                        true
                    }
                    R.id.bottom_nav_extension->{
                        startActivity(Intent(this,TienIchActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity,R.anim.animation_activity)
                        true
                    }
                    R.id.bottom_nav_work->{
                        if(taikhoan.quyen == "admin") {
                            startActivity(Intent(this,QuanLiActivity::class.java))
                            overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                        }
                        true
                    }
                    R.id.bottom_nav_chart->{
                        if(taikhoan.quyen == "admin") {
                            startActivity(Intent(this,ThongKeActivity::class.java))
                            overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                        }
                        true
                    }
                    else -> false
                }


        }
    }
}