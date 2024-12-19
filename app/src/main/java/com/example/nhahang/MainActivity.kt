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
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Node

class MainActivity : AppCompatActivity() {
    //khai bao thuoc tinh
    private lateinit var viewPage : ViewPager2
    private var recyclerItems : MutableList<RecyclerItem> = mutableListOf()
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerTopProducts : RecyclerView
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var edtTimKiem : SearchView
    private lateinit var adapter : RecyclerTopProductsAdapter
    private lateinit var db : AppDatabase
    private lateinit var monAnDAO : MonAnDAO
    private lateinit var items :List<MonAn>

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
        event()
    }
    //create database
    fun createDataBase(){
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"nhahang_db"
        ).build()
        monAnDAO = db.monAnDAO()
        //chen du lieu vao danh sach mon an
        GlobalScope.launch(Dispatchers.IO) {
            val monAn1 = MonAn(tenMon = "Tôm sốt thái",moTa = "Tôm tươi được chế biến với sốt Thái cay cay, chua ngọt đặc trưng, đậm đà hương vị Đông Nam Á.",giaMon = 129000,anh = R.drawable.img_top_product1,danhMuc = "Món ăn")
            val monAn2 = MonAn(tenMon = "Chân gà xả tắc",moTa = "Chân gà dai giòn, ngâm cùng sả thơm, tắc chua và gia vị cay nồng, tạo nên món ăn vặt hấp dẫn",giaMon = 119000,anh = R.drawable.img_top_product2,danhMuc = "Món ăn")
            val monAn3 = MonAn(tenMon = "Tôm sốt thái",moTa = "Tôm tươi được tẩm sốt Thái đậm vị, kết hợp cùng các loại rau thơm và gia vị chua cay hoàn hảo",giaMon = 129000,anh = R.drawable.img_top_product3,danhMuc = "Món ăn")
            val monAn4 = MonAn(tenMon = "Hàu nướng phô mai",moTa = "Hàu tươi nướng béo ngậy, phủ lớp phô mai tan chảy thơm lừng, là món ăn ngon khó cưỡng",giaMon = 69000,anh = R.drawable.img_top_product4,danhMuc = "Món ăn")
            val monAn5 = MonAn(tenMon = "Pessi",moTa = "",giaMon = 20000,anh = R.drawable.img_4,danhMuc = "Nước")
            val monAn6 = MonAn(tenMon = "Coca cola",moTa = "",giaMon = 20000,anh = R.drawable.img_5,danhMuc = "Nước")
            val monAn7 = MonAn(tenMon = "Beer",moTa = "",giaMon = 25000,anh = R.drawable.img_6,danhMuc = "Nước")
            val monAn8 = MonAn(tenMon = "Beer",moTa = "",giaMon = 20000,anh = R.drawable.img_7,danhMuc = "Nước")

//            monAnDAO.InsertMonAn(monAn1)
//            monAnDAO.InsertMonAn(monAn2)
//            monAnDAO.InsertMonAn(monAn3)
//            monAnDAO.InsertMonAn(monAn4)
//            monAnDAO.InsertMonAn(monAn5)
//            monAnDAO.InsertMonAn(monAn6)
//            monAnDAO.InsertMonAn(monAn7)
//            monAnDAO.InsertMonAn(monAn8)
        }
    }



    //set control
    fun setControl(){
        edtTimKiem = findViewById(R.id.searchView)
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
         items = listOf()
         adapter = RecyclerTopProductsAdapter(this,items)
        loadTopSanPham()
        recyclerTopProducts.layoutManager = GridLayoutManager(this,2)
        recyclerTopProducts.adapter = adapter
        edtTimKiem.setOnQueryTextListener( object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val newList = items.filter { item->
                    item.tenMon.contains(newText.toString(),ignoreCase = true)
                }
                adapter.updateData(newList)
                return true
            }

        })
        //        {
//            val searchText = it?.toString() ?: ""
//            // Lọc danh sách theo nội dung tìm kiếm
//            val filteredList = items.filter { item ->
//                item.tenMon.contains(searchText, ignoreCase = true)
//            }
//             //Cập nhật danh sách trong adapter
//            adapter.updateData(filteredList)
//        }
    }

    fun loadTopSanPham(){
        GlobalScope.launch(Dispatchers.IO) {
            items =  monAnDAO.getAllMonAns()
            withContext(Dispatchers.Main){
                adapter.updateData(items)
            }
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
                        true
                    }else{
                        false
                    }
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
                        true
                    }else{
                        false
                    }
                }
                R.id.bottom_nav_extension->{
                    startActivity(Intent(this,TienIchActivity::class.java))
                    overridePendingTransition(R.anim.animation_activity, R.anim.animation_activity)
                    true
                }else -> false
            }
        }

    }
    //set event
    fun event(){
//        setSupportActionBar(tbMain)
//        supportActionBar?.title = "Home"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}