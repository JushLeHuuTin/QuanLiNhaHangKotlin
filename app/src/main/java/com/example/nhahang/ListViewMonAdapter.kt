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
import java.text.NumberFormat
import java.util.Locale

class ListViewMonAdapter(val context : Context, val items : List<MonAn>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): MonAn {
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
        img.setBackgroundResource(currentItem.anh)
        view.setOnClickListener {
            when(currentItem.anh){
                R.drawable.img ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
                }
                R.drawable.img_3 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
               }
                R.drawable.img_2 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
                 }
                R.drawable.img_1 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
               }
                R.drawable.img_4 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
                }
                R.drawable.img_5 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
                }
                R.drawable.img_6 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
                }
                R.drawable.img_7 ->{
                    setInfo(currentItem.tenMon,currentItem.giaMon.toString(),currentItem.anh,currentItem.moTa)
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
         val format = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
         tvPriceMon.text = format.format(giaMon.toDouble())
         tvDESMon.text = motaMon

     }
}