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
    private lateinit var itemsMonAn : MutableList<MonAn>
    private lateinit var itemsNuoc : MutableList<MonAn>
    private lateinit var btnQuanliMon : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_mon)
        setControll()
        setEventt()
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
        itemsMonAn.add(MonAn("Spaghetti: Pepperoni","Món mì spaghetti phô mai kem là một món pasta thơm ngon",129000 ,R.drawable.img))
        itemsMonAn.add(MonAn("Spaghetti: Pepper Lunch","Món spaghetti Pepper Lunch là một món ăn phổ biến ở Nhật Bản, thường được phục vụ như một lựa chọn bữa trưa nhanh gọn và tiện lợi. Món ăn này kết hợp hương vị của mì spaghetti Ý với sốt tiêu cay, loại nước sốt thường được sử dụng trong ẩm thực Nhật Bản. Kết quả là một bữa ăn thơm ngon và đầy hương vị, rất phù hợp cho những ai yêu thích món ăn đậm đà và cay nồng.",129000 ,R.drawable.img_2))
        itemsMonAn.add(MonAn("Spaghetti: Pepperoni","Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein.",129000 ,R.drawable.img_3))
        itemsMonAn.add(MonAn("Spaghetti: Bolognese","Món spaghetti Bolognese là một bữa ăn bổ dưỡng và ấm áp, hoàn hảo cho một bữa tối ấm cúng tại nhà. Đây cũng là một món ăn tuyệt vời để chuẩn bị trước và đông lạnh để dùng sau. Hương vị của nước sốt càng đậm đà theo thời gian, khiến món ăn trở nên ngon hơn vào ngày hôm sau.",119000,R.drawable.img_1))
        itemsNuoc.add(MonAn("PESSI","",20000,R.drawable.img_4))
        itemsNuoc.add(MonAn("COCA","",20000,R.drawable.img_5))
        itemsNuoc.add(MonAn("BIAHOI","",35000,R.drawable.img_6))
        itemsNuoc.add(MonAn("BEER","",20000,R.drawable.img_7))
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
            startActivity(Intent(this,MenuMonActivity::class.java))
        }
    }

}