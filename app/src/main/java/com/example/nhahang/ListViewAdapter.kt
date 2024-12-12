package com.example.nhahang

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class ListViewAdapter (val context: Context,val items : List<Int>):BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Int {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        var view = p1
        if(view == null) view  = inflater.inflate(R.layout.listview_item,p2,false)
         val imageView : ImageView = view!!.findViewById(R.id.img_listView)
         imageView.setImageResource(getItem(p0))

        var currentItem = items[p0]
        view.setOnClickListener {
            when(currentItem){
                R.drawable.img_lv_banner1->{

                    context.startActivity(Intent(context,ChiTietSanPhamActivity::class.java))
                }
            }
        }

        return view
    }
}