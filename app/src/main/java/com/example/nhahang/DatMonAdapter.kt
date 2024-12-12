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

class DatMonAdapter(val context : Context, val listMon : List<BillInfo>,
                    private val tvTotalPrice: TextView? = null): BaseAdapter() {
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
            view = inflater.inflate(R.layout.item_datmon,p2,false)
        }
        val imgAnhMon : ImageView = view!!.findViewById(R.id.imgMonAn)
        val tvGiaMon : TextView = view.findViewById(R.id.tvGiaMon)
        val tvSoLuong : TextView = view.findViewById(R.id.tvSoLuong)
        val btnRemove: View = view.findViewById(R.id.btnDeleteMon)
        val btnAdd: View = view.findViewById(R.id.btnAddMon)
        val currentItem = getItem(p0)
        var thanhTien :Double = currentItem.price * currentItem.quantity
        btnRemove.setOnClickListener {
            if(currentItem.quantity>0){
                currentItem.quantity--
                thanhTien = (currentItem.price * currentItem.quantity)
                notifyDataSetChanged()
                updateTotalPrice()
            }
        }
        btnAdd.setOnClickListener {

            currentItem.quantity++
             thanhTien  = (currentItem.price * currentItem.quantity)
            notifyDataSetChanged()
            updateTotalPrice()
        }
        imgAnhMon.setImageResource(currentItem.foodImg)
        val format = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))

        tvGiaMon.text = format.format(thanhTien).toString()
        tvSoLuong.text = currentItem.quantity.toString()
        updateTotalPrice()
        return view
    }
    private fun updateTotalPrice() {

        val totalPrice = listMon.sumOf { it.price * it.quantity }
        val format = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
        tvTotalPrice?.text = "Tổng tiền: ${format.format(totalPrice)}"
    }
}