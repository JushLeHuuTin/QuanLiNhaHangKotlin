package com.example.nhahang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GoiMonActivity : AppCompatActivity() {
//    private lateinit var imgMon1 : ImageView
//    private lateinit var imgMon2 : ImageView
    private lateinit var tv_TableName : TextView
    private lateinit var btnMon : Button
    private lateinit var btnNuoc : Button
    private lateinit var btnCart : Button
//    private lateinit var lo_DisPlayMon : LinearLayout
//    private lateinit var imgMon : ImageView
//    private lateinit var tvNameMon : TextView
//    private lateinit var tvPriceMon : TextView
//    private lateinit var tvDESMon : TextView
    //list view
    private lateinit var lv : ListView
    private lateinit var itemsMonAn : MutableList<MonAn>
    private lateinit var itemsNuoc : MutableList<MonAn>
    private lateinit var monAnDAO :MonAnDAO
    private lateinit var adapter : ListViewMonAdapter
    private lateinit var db : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_goi_mon)
       setControll()
        setEventt()
    }

    //set controll
    fun setControll(){
        lv = findViewById(R.id.lv_GoiMon)
        itemsMonAn = mutableListOf()
        itemsNuoc = mutableListOf()
        btnCart = findViewById(R.id.btnCart)
        btnMon = findViewById(R.id.btnMon)
        btnNuoc = findViewById(R.id.btnNuoc)
        tv_TableName = findViewById(R.id.tv_TableName)

    }
    //set eventt
    fun setEventt(){
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"nhahang_db"
        ).build()
        monAnDAO = db.monAnDAO()
         adapter = ListViewMonAdapter(this,itemsMonAn)
        lv.adapter = adapter
        load()
        tv_TableName.text = intent.getStringExtra("TableName")
        btnCart.setOnClickListener {
            val intent = Intent(this,XacNhanThemMonActivity::class.java)
            intent.putExtra("TableName",tv_TableName.text)
            startActivity(intent)
        }
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
    }

    fun load(type : String = "Món ăn"){
        GlobalScope.launch(Dispatchers.IO) {
            var items : List<MonAn> = listOf()
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


    //set control
//    fun setControl(){
//        imgMon1 = findViewById(R.id.img_Mon1)
//        imgMon2 = findViewById(R.id.img_Mon2)
//        tv_TableName = findViewById(R.id.tv_TableName)
//        btnNuoc = findViewById(R.id.btnNuoc)
//        btnMon = findViewById(R.id.btnMon)
//        btnCart = findViewById(R.id.btnCart)
//        lo_DisPlayMon = findViewById(R.id.lo_DisPlayMon)
//        imgMon = findViewById(R.id.img_Mon)
//        tvNameMon = findViewById(R.id.tv_nameMon)
//        tvDESMon = findViewById(R.id.tv_desMon)
//        tvPriceMon = findViewById(R.id.tv_priceMon)
//    }
    //set event
//    fun setEvent(){
//        val tableName = intent.getStringExtra("TableName")
//        tv_TableName.text = tableName
//        btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
//        imgMon1.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in)
//            lo_DisPlayMon.startAnimation(animation)
//            val btnAddMon : Button = findViewById(R.id.btn_AddMon)
//            btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
//            btnAddMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
//            btnAddMon.text = "Thêm món"
//            imgMon.setBackgroundResource(R.drawable.img)
//            tvNameMon.text = "Spaghetti: Cream Che ese"
//            tvPriceMon.text = "140.000 VND"
//            tvDESMon.text = "Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein."
//        }
//
//        imgMon2.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in)
//            lo_DisPlayMon.startAnimation(animation)
//            val btnAddMon : Button = findViewById(R.id.btn_AddMon)
//            btnAddMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
//            btnAddMon.text = "Thêm món"
//            btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
//            imgMon.setBackgroundResource(R.drawable.img_1)
//            tvNameMon.text = "Spaghetti: Cream Cheese"
//            tvPriceMon.text = "129.000 VND"
//            tvDESMon.text = "Spaghetti cream cheese is a delicious and creamy pasta dish that is perfect for any occasion. This dish combines the rich and savory flavors of spaghetti with the smooth and tangy taste of cream cheese, creating a mouthwatering and indulgent meal. The cream cheese adds a luxurious and velvety texture to the spaghetti, while also adding a touch of tanginess that perfectly balances the richness of the dish. This pasta dish is easy to prepare and can be customized with various ingredients such as herbs, vegetables, and proteins to suit your taste preferences."
//        }
//
//        btnNuoc.setOnClickListener {
//            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
//            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
////            btnNuoc.setBackgroundResource(R.drawable.shape_inputsearch)
////            btnMon.setBackgroundResource(R.drawable.btn_select)
//        }
//        btnMon.setOnClickListener {
//            btnMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
//            btnNuoc.backgroundTintList = ContextCompat.getColorStateList(this,R.color.transparent)
//
//        }
//        btnCart.setOnClickListener {
//            startActivity(Intent(this,GioHangActivity::class.java))
//        }
//    }
}