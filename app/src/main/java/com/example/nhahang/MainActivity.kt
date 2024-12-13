package com.example.nhahang

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.ListView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Node

class MainActivity : AppCompatActivity() {
    //khai bao thuoc tinh
    private lateinit var viewPage : ViewPager2
    private var recyclerItems : MutableList<RecyclerItem> = mutableListOf()
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerTopProducts : RecyclerView
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var edtTimKiem : EditText
    private lateinit var myDataBase : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setControl()
        createDataBase()
        doDuLieuVaoViewPage()

        //goi ham load list recycler view(danh mục sản phẩm)
        doDuLieuVaoRecyler()

        //goi ham load (top sản phẩm)
        doDuLieuVaoRecylerView()



        //goi ham setevent bottom nav
        setEventNav()
    }
    //create database
    fun createDataBase(){
        //tạo database
        try {
            myDataBase = openOrCreateDatabase("qlnhahang.db", MODE_PRIVATE, null)
            Log.d("SQL", "Cơ sở dữ liệu đã mở thành công.")
        } catch (e: Exception) {
            Log.e("Error", "Không thể mở cơ sở dữ liệu: ${e.message}")
        }
        try {
            myDataBase.execSQL("DROP TABLE IF EXISTS TBMonAn")
            val sql = "CREATE table TBMonAn (MaMon TEXT primary key, TenMon Text,MoTa Text,Gia REAL,anh INTEGER)"
            myDataBase.execSQL(sql)
        }catch( ex: Exception){
            Log.e("Error SQL",ex.message.toString())
        }
        //insert data into TBMonAn
        try{
            val sql1 = " INSERT INTO TBMonAn (MaMon, TenMon, MoTa, Gia,anh) " +
                    "VALUES ('M001', 'Tôm sốt thái', 'Tôm tươi được chế biến với sốt Thái cay cay, chua ngọt đặc trưng, đậm đà hương vị Đông Nam Á.', 129.000,${R.drawable.img_top_product1}) "
            val sql2 = " INSERT INTO TBMonAn (MaMon, TenMon, MoTa, Gia,anh) " +
                    "VALUES ('M002', 'Chân gà xả tắc', 'Chân gà dai giòn, ngâm cùng sả thơm, tắc chua và gia vị cay nồng, tạo nên món ăn vặt hấp dẫn', 119.000,${R.drawable.img_top_product2}) "
            val sql3 = " INSERT INTO TBMonAn (MaMon, TenMon, MoTa, Gia,anh) " +
                    "VALUES ('M003', 'Tôm sốt thái', 'Tôm tươi được tẩm sốt Thái đậm vị, kết hợp cùng các loại rau thơm và gia vị chua cay hoàn hảo', 129.000,${R.drawable.img_top_product3}) "
            val sql4 = " INSERT INTO TBMonAn (MaMon, TenMon, MoTa, Gia,anh) " +
                    "VALUES ('M004', 'Hàu nướng phô mai', 'Hàu tươi nướng béo ngậy, phủ lớp phô mai tan chảy thơm lừng, là món ăn ngon khó cưỡng', 69.000,${R.drawable.img_top_product4}) "
            myDataBase.execSQL(sql1)
            myDataBase.execSQL(sql2)
            myDataBase.execSQL(sql3)
            myDataBase.execSQL(sql4)

        }catch( ex: Exception){
            Log.e("Error SQL",ex.message.toString())
        }
    }
    //set control
    fun setControl(){
        edtTimKiem = findViewById(R.id.edtTimKiem)
    }
    //do du lieu banner vao view page 2
    fun doDuLieuVaoViewPage(){
        viewPage = findViewById(R.id.vpBanner)
        var items = mutableListOf<Int>()
        items.add(R.drawable.img_lv_banner3)
        items.add(R.drawable.img_lv_banner1)
        val adapter = ViewPageAdapter(this,items)
        viewPage.adapter = adapter
    }
    //do du lieu recycler adapter vao recycler
    fun doDuLieuVaoRecyler(){
        recyclerView = findViewById(R.id.reyclerView)
        //add list recycler
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_all,"All"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_breakfastt,"Breakfast"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_lunch,"Lunch"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_dinner,"Dinner"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_healthy,"Healthy"))
        recyclerItems.add(RecyclerItem(R.drawable.img_topnav_desert,"Desert"))
        //khai bao adapter
        val adapterRecycler = RecyclerAdapter(this,recyclerItems)
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapterRecycler
    }


    fun doDuLieuVaoRecylerView(){
        recyclerTopProducts = findViewById(R.id.recyclerTopProducts)
        val items  : MutableList<RecyclerTopProductsItem> = mutableListOf()
        var cursor : Cursor = myDataBase.query("TBMonAn",null,null,null,null,null,null,null)
        if ( cursor.moveToFirst()) {
            do {
                val name = cursor.getString(1)
                val price = cursor.getDouble(3)
                val imageResId = cursor.getInt(4)

                // Thêm item vào danh sách
                items.add(RecyclerTopProductsItem(name, price, imageResId))
            } while (cursor.moveToNext())
        }
        cursor.close()
//        items.add(RecyclerTopProductsItem("Tôm sốt thái",129.000,R.drawable.img_top_product1))
//        items.add(RecyclerTopProductsItem("Chân gà xả tắc",119.000,R.drawable.img_top_product2))
//        items.add(RecyclerTopProductsItem("Tôm sốt thái",129.000,R.drawable.img_top_product3))
//        items.add(RecyclerTopProductsItem("Hàu nướng phô mai",69.000,R.drawable.img_top_product4))
//        //khai bao adapter
        val adapter = RecyclerTopProductsAdapter(this,items)

        recyclerTopProducts.layoutManager = GridLayoutManager(this,2)
        recyclerTopProducts.adapter = adapter
        edtTimKiem.addTextChangedListener {
            val searchText = it?.toString() ?: ""
            // Lọc danh sách theo nội dung tìm kiếm
            val filteredList = items.filter { item ->
                item.name.contains(searchText, ignoreCase = true)
            }
             //Cập nhật danh sách trong adapter
            adapter.updateData(filteredList)
        }

    }

    //thuc hien event
    fun setEventNav(){
        bottomNav = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.bottom_nav_home
        bottomNav.setOnNavigationItemSelectedListener { i ->
            when(i.itemId){
                R.id.bottom_nav_home->{
                    startActivity(Intent(this,MainActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_chart->{
                    if(taikhoan.quyen == "admin") {
                        startActivity(Intent(this,ThongKeActivity::class.java))
                        overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    }
                    true
                }
                R.id.bottom_nav_location->{
                    startActivity(Intent(this,KhuVucActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }
                R.id.bottom_nav_work->{
                    if(taikhoan.quyen == "admin") {
                    startActivity(Intent(this,QuanLiActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    }
                    false
                }
                R.id.bottom_nav_extension->{
                    startActivity(Intent(this,TienIchActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }else -> false
            }
        }

    }

}