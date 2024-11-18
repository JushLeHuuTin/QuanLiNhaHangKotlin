package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class KhuVucActivity : AppCompatActivity() {
    private lateinit var recyclerTable : RecyclerView
    private lateinit var items : MutableList<ItemTable>
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
        items = mutableListOf()
        for(i in 1..15){
            if( i % 5 == 0){
                items.add(ItemTable("Bàn " + i,1))
            }
            else items.add(ItemTable("Bàn " + i,0))
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
        val adapter = RecyclerTableAdapter(this,items)
        recyclerTable.adapter = adapter
    }
    //get event select tang
    fun setEvent(){
        btnTang2.setOnClickListener {
            btnTang2.setBackgroundResource(R.drawable.shape_occupied_table)
            btnTang1.setBackgroundResource(R.drawable.btn_select)
        }
        btnTang1.setOnClickListener {
            btnTang1.setBackgroundResource(R.drawable.shape_occupied_table)
            btnTang2.setBackgroundResource(R.drawable.btn_select)
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
                    R.id.bottom_nav_chart->{
                        startActivity(Intent(this,ThongKeActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity,R.anim.animation_activity)
                        true
                    }
                    else -> false
                }


        }
    }
}