package com.example.nhahang

import android.app.Activity
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class ListViewMonAdapter(val context : Context, val items : List<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        var view = p1
        if(view == null) view = inflater.inflate(R.layout.listview_item_monan,p2,false)
        val img : ImageView = view!!.findViewById(R.id.img_GoiMonAn)
        val lo_DisPlayMon : LinearLayout = (context as Activity).findViewById(R.id.lo_DisPlayMon)
        val btnAddMon : Button = (context as Activity).findViewById(R.id.btn_AddMon)
        val imgMon : ImageView = (context as Activity).findViewById(R.id.img_Mon)
        val tvNameMon : TextView = (context as Activity).findViewById(R.id.tv_nameMon)
        val tvDESMon :TextView = (context as Activity).findViewById(R.id.tv_desMon)
        val tvPriceMon : TextView = (context as Activity).findViewById(R.id.tv_priceMon)
        val currentItem = items[p0]
        img.setBackgroundResource(currentItem)
        view.setOnClickListener {
            when(currentItem){
                R.drawable.img ->{
                    val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in)
                    lo_DisPlayMon.startAnimation(animation)

                    btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
                    btnAddMon.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
                    btnAddMon.text = "Thêm món"

                    imgMon.setBackgroundResource(R.drawable.img)
                    tvNameMon.text = "Spaghetti: Cream Che ese"
                    tvPriceMon.text = "140.000 VND"
                    tvDESMon.text = "Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein."

                }
                R.drawable.img_2 ->{
                    val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in)
                    lo_DisPlayMon.startAnimation(animation)

                    btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
                    btnAddMon.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
                    btnAddMon.text = "Thêm món"

                    imgMon.setBackgroundResource(R.drawable.img_2)
                    tvNameMon.text = "Spaghetti: Cream Cheese"
                    tvPriceMon.text = "129.000 VND"
                    tvDESMon.text = "Spaghetti cream cheese is a delicious and creamy pasta dish that is perfect for any occasion. This dish combines the rich and savory flavors of spaghetti with the smooth and tangy taste of cream cheese, creating a mouthwatering and indulgent meal. The cream cheese adds a luxurious and velvety texture to the spaghetti, while also adding a touch of tanginess that perfectly balances the richness of the dish. This pasta dish is easy to prepare and can be customized with various ingredients such as herbs, vegetables, and proteins to suit your taste preferences.";

                }
                R.drawable.img_4 ->{
                    val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in)
                    lo_DisPlayMon.startAnimation(animation)

                    btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
                    btnAddMon.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
                    btnAddMon.text = "Thêm món"

                    imgMon.setBackgroundResource(R.drawable.img_4)
                    tvNameMon.text = "PESSI"
                    tvPriceMon.text = "20.000 VND"
                    tvDESMon.text = ""
                }
                R.drawable.img_6 ->{
                    val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in)
                    lo_DisPlayMon.startAnimation(animation)

                    btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
                    btnAddMon.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
                    btnAddMon.text = "Thêm món"

                    imgMon.setBackgroundResource(R.drawable.img_6)
                    tvNameMon.text = "Bia Hơi"
                    tvPriceMon.text = "35.000 VND"
                    tvDESMon.text = ""
                }
            }
        }
        return view
    }
}