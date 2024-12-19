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
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuMonActivity : AppCompatActivity() {
    private lateinit var btnMon : Button
    private lateinit var btnNuoc : Button
    private lateinit var lv : ListView
    private lateinit var items : List<MonAn>
    private lateinit var btnQuanliMon : Button
    private lateinit var adapter : ListViewMonAdapter
    private lateinit var db : AppDatabase
    private lateinit var monAnDAO : MonAnDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_mon)
        setControll()
        setEventt()
    }
    fun setControll(){
        lv = findViewById(R.id.lv_GoiMon)
        items = mutableListOf()
        btnMon = findViewById(R.id.btnMon)
        btnNuoc = findViewById(R.id.btnNuoc)
        btnQuanliMon = findViewById(R.id.btnQuanliMon)
    }
    fun setEventt(){
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"nhahang_db"
        ).build()
        monAnDAO = db.monAnDAO()
         adapter = ListViewMonAdapter(this,items)
        lv.adapter = adapter
        load()
        btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
        btnMon.setOnClickListener {
            load("Món ăn")
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnNuoc.setOnClickListener {
            load("Nước")
            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
        }
        btnQuanliMon.setOnClickListener {
            startActivity(Intent(this,MenuMonActivity::class.java))
        }
    }
    fun load(type : String = "Món ăn"){
        GlobalScope.launch(Dispatchers.IO) {
            items = listOf()
            if(type == "Món ăn"){
                items =  monAnDAO.getAllMonAns()
            }else if(type == "Nước"){
                items =  monAnDAO.getAllNuocs()
            }else{
                items = monAnDAO.getAllMons()
            }

            withContext(Dispatchers.Main){
                adapter.updateData(items)
            }
        }
    }
}