package com.example.nhahang

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
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
        return view
    }
}