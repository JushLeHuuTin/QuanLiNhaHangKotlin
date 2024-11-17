package com.example.nhahang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DemoListView(var context : Context, val items : List<RecyclerItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): RecyclerItem {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if(view == null){
            val inflater = LayoutInflater.from(context)
            view  = inflater.inflate(R.layout.recycler_item,p2,false)
        }
        val textView : TextView = view!!.findViewById(R.id.tv_topnav)
        val imageView : ImageView = view.findViewById(R.id.img_topnav)
        val currentItem = getItem(p0)
        textView.text = currentItem.title
        imageView.setImageResource(currentItem.img)
        return view
    }
}