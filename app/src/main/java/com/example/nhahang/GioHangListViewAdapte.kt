package com.example.nhahang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.Locale

class GioHangListViewAdapte(val context : Context,val listMon : List<BillInfo>,
                            private val tvTotalPrice: TextView? = null):BaseAdapter() {
    override fun getCount(): Int {
        return listMon.size
    }

    override fun getItem(p0: Int): BillInfo {
        return listMon[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = LayoutInflater.from(context)
        var view = p1;
        if(view == null) {
            view = inflater.inflate(R.layout.item_giohang_monan,p2,false)
        }
        val imgAnhMon :ImageView = view!!.findViewById(R.id.imgMonAn)
        val tvGiaMon : TextView = view.findViewById(R.id.tvGiaMon)
        val tvSoLuong : TextView = view.findViewById(R.id.tvSoLuong)
        val tvTenMon : TextView = view.findViewById(R.id.tvTenMon)

        val currentItem = getItem(p0)

        imgAnhMon.setImageResource(currentItem.foodImg)
        tvGiaMon.text = (currentItem.price * currentItem.quantity).toString()
        tvSoLuong.text = "x" +currentItem.quantity.toString()
        tvTenMon.text = currentItem.foodName
        return view
    }

}