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
        val currentItem = items[p0]
        img.setBackgroundResource(currentItem)
        view.setOnClickListener {
            when(currentItem){
                R.drawable.img ->{
                    setInfo("Spaghetti: Cream Cheese","140.000 VND",R.drawable.img,"Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein.")
                }
                R.drawable.img_3 ->{
                    setInfo("Spaghetti: Pepperoni","129.000 VND",R.drawable.img_3,"Món mì spaghetti phô mai kem là một món pasta thơm ngon và béo ngậy, hoàn hảo cho mọi dịp. Món ăn này kết hợp hương vị đậm đà và thơm ngon của mì spaghetti với vị mềm mịn và chua nhẹ của phô mai kem, tạo nên một bữa ăn đầy hấp dẫn và thỏa mãn vị giác. Phô mai kem không chỉ mang đến kết cấu mượt mà, sang trọng cho món mì mà còn thêm vào chút vị chua nhẹ, giúp cân bằng sự béo ngậy của món ăn. Món pasta này rất dễ chế biến và có thể tùy chỉnh theo sở thích với nhiều nguyên liệu khác nhau như thảo mộc, rau củ và các loại protein.")
                }
                R.drawable.img_2 ->{
                    setInfo("Spaghetti: Pepper Lunch","129.000 VND",R.drawable.img_2,"Món spaghetti Pepper Lunch là một món ăn phổ biến ở Nhật Bản, thường được phục vụ như một lựa chọn bữa trưa nhanh gọn và tiện lợi. Món ăn này kết hợp hương vị của mì spaghetti Ý với sốt tiêu cay, loại nước sốt thường được sử dụng trong ẩm thực Nhật Bản. Kết quả là một bữa ăn thơm ngon và đầy hương vị, rất phù hợp cho những ai yêu thích món ăn đậm đà và cay nồng.\n" +
                            "\n" +
                            "Món ăn này thường bao gồm mì spaghetti được nấu đến độ al dente, tức là vừa chín tới nhưng vẫn giữ được độ dai. Mì được trộn đều với rau củ xào, bao gồm hành tây, tỏi, và ớt chuông. Nước sốt được làm từ nước tương và dầu ớt, tạo nên hương vị cay đặc trưng cho món ăn.")
                }
                R.drawable.img_1 ->{
                    setInfo("Spaghetti: Bolognese","129.000 VND",R.drawable.img_1,"Món spaghetti Bolognese là một bữa ăn bổ dưỡng và ấm áp, hoàn hảo cho một bữa tối ấm cúng tại nhà. Đây cũng là một món ăn tuyệt vời để chuẩn bị trước và đông lạnh để dùng sau. Hương vị của nước sốt càng đậm đà theo thời gian, khiến món ăn trở nên ngon hơn vào ngày hôm sau.")
                }
                R.drawable.img_4 ->{
                    setInfo("PESSI","20.000 VND",R.drawable.img_4,"")
                }
                R.drawable.img_5 ->{
                    setInfo("COCA","20.000 VND",R.drawable.img_5,"")
                }
                R.drawable.img_6 ->{
                    setInfo("Bia Hơi","35.000 VND",R.drawable.img_6,"")
                }
                R.drawable.img_7 ->{
                    setInfo("BEER","20.000 VND",R.drawable.img_7,"")
                }
            }
        }
        return view
    }
     fun setInfo(tenMon : String,giaMon : String,anhMon : Int ,motaMon : String){
         //anh xạ
         val lo_DisPlayMon : LinearLayout = (context as Activity).findViewById(R.id.lo_DisPlayMon)
         val btnAddMon : Button = (context).findViewById(R.id.btn_AddMon)
         val imgMon : ImageView = (context).findViewById(R.id.img_Mon)
         val tvNameMon : TextView = (context).findViewById(R.id.tv_nameMon)
         val tvDESMon :TextView = (context).findViewById(R.id.tv_desMon)
         val tvPriceMon : TextView = (context).findViewById(R.id.tv_priceMon)
         val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in)
         //set gia tri
         lo_DisPlayMon.startAnimation(animation)
         btnAddMon.setBackgroundResource(R.drawable.shape_inputsearch)
         btnAddMon.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
         btnAddMon.text = "Thêm món"
         imgMon.setBackgroundResource(anhMon)
         tvNameMon.text = tenMon
         tvPriceMon.text = giaMon
         tvDESMon.text = motaMon

     }
}