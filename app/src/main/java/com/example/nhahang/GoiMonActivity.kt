package com.example.nhahang

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GoiMonActivity : AppCompatActivity() {
    private lateinit var imgMon1 : ImageView
    private lateinit var imgMon2 : ImageView

    private lateinit var imgMon : ImageView
    private lateinit var tvNameMon : TextView
    private lateinit var tvPriceMon : TextView
    private lateinit var tvDESMon : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_goi_mon)
       setControl()
        setEvent()
    }
    //set control
    fun setControl(){
        imgMon1 = findViewById(R.id.img_Mon1)
        imgMon2 = findViewById(R.id.img_Mon2)
        imgMon = findViewById(R.id.img_Mon)
        tvNameMon = findViewById(R.id.tv_nameMon)
        tvDESMon = findViewById(R.id.tv_desMon)
        tvPriceMon = findViewById(R.id.tv_priceMon)
    }
    //set event
    fun setEvent(){
        imgMon1.setOnClickListener {
            val btnAddMon : Button = findViewById(R.id.btn_AddMon)
            btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
            btnAddMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnAddMon.text = "Thêm món"
            imgMon.setBackgroundResource(R.drawable.img)
            tvNameMon.text = "Spaghetti: Cream Che ese"
            tvPriceMon.text = "140.000 VND"
            tvDESMon.text = "Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein."
        }

        imgMon2.setOnClickListener {
            val btnAddMon : Button = findViewById(R.id.btn_AddMon)
            btnAddMon.backgroundTintList = ContextCompat.getColorStateList(this,R.color.primary_color)
            btnAddMon.text = "Thêm món"
            btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
            imgMon.setBackgroundResource(R.drawable.img_1)
            tvNameMon.text = "Spaghetti: Cream Cheese"
            tvPriceMon.text = "129.000 VND"
            tvDESMon.text = "Spaghetti cream cheese is a delicious and creamy pasta dish that is perfect for any occasion. This dish combines the rich and savory flavors of spaghetti with the smooth and tangy taste of cream cheese, creating a mouthwatering and indulgent meal. The cream cheese adds a luxurious and velvety texture to the spaghetti, while also adding a touch of tanginess that perfectly balances the richness of the dish. This pasta dish is easy to prepare and can be customized with various ingredients such as herbs, vegetables, and proteins to suit your taste preferences."
        }
    }
}