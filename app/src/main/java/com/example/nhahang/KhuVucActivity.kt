package com.example.nhahang

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class KhuVucActivity : AppCompatActivity() {
    private lateinit var recyclerTable : RecyclerView
    private lateinit var recyclerItems : MutableList<RecyclerItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_khu_vuc)
        recyclerTable = findViewById(R.id.recyclerTable)
        recyclerItems = mutableListOf()
//        for(i in 1..15){
//            items.add(ItemTable("Bàn " + i,1))
//        }
//        Toast.makeText(this, items[0].name, Toast.LENGTH_SHORT).show()
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_all,"All"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_breakfastt,"Breakfast"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_lunch,"Lunch"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_dinner,"Dinner"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_healthy,"Healthy"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_desert,"Desert"))
        //khai bao adapter
//        val adapterRecycler = RecyclerAdapter(this,recyclerItems)
        val adapter = RecyclerAdapter(this,recyclerItems)
        recyclerTable.adapter = adapter
    }
    //set control
//    fun setControl(){
//        recyclerTable = findViewById(R.id.recyclerTable)
//        items = mutableListOf()
//        for(i in 1..15){
//            items.add(ItemTable("Bàn " + i,0))
//        }
//    }
//    //get list table
//    fun getTable(){
//        val adapter = RecyclerTableAdapter(this,items)
//        recyclerTable.adapter = adapter
//    }
}