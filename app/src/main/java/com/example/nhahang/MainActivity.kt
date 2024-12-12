package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //khai bao thuoc tinh
    private lateinit var viewPage : ViewPager2
    private var recyclerItems : MutableList<RecyclerItem> = mutableListOf()
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerTopProducts : RecyclerView
    private lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        doDuLieuVaoViewPage()

        //goi ham load list recycler view
        doDuLieuVaoRecyler()

        //goi ham load list view
        doDuLieuVaoListView()



        //goi ham setevent bottom nav
        setEventNav()
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
    //do du lieu listview adapter vao list view
//        //khai bao adapter
//    }

    fun doDuLieuVaoListView(){
        recyclerTopProducts = findViewById(R.id.recyclerTopProducts)
        val items  : MutableList<RecyclerTopProductsItem> = mutableListOf()
        items.add(RecyclerTopProductsItem("Tôm sốt thái",129.000,R.drawable.img_top_product1))
        items.add(RecyclerTopProductsItem("Chân gà xả tắc",119.000,R.drawable.img_top_product2))
        items.add(RecyclerTopProductsItem("Tôm sốt thái",129.000,R.drawable.img_top_product3))
        items.add(RecyclerTopProductsItem("Hàu nướng phô mai",69.000,R.drawable.img_top_product4))
        //khai bao adapter
        val adapter = RecyclerTopProductsAdapter(this,items)
        recyclerTopProducts.layoutManager = GridLayoutManager(this,2)
        recyclerTopProducts.adapter = adapter
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
                    } else {
                        Toast.makeText(this, "Bạn không có quyền!", Toast.LENGTH_SHORT).show()
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
                    } else {
                        Toast.makeText(this, "Bạn không có quyền!", Toast.LENGTH_SHORT).show()
                    }
                    true
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