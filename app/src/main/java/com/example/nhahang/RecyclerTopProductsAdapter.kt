package com.example.nhahang

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class RecyclerTopProductsAdapter(val context: Context, var items : List<MonAn>) : RecyclerView.Adapter<RecyclerTopProductsAdapter.ItemVewHolder>(){
    class ItemVewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgProduct : ImageView = itemView.findViewById(R.id.imgProduct)
        val tvProductName : TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice : TextView = itemView.findViewById(R.id.tvProductPrice)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemVewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_top_san_pham,parent,false)
        return ItemVewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemVewHolder, position: Int) {
        val currentItem = items[position]
        holder.imgProduct.setImageResource(currentItem.anh)
        var format = NumberFormat.getCurrencyInstance(Locale("vi","VN"))
        holder.tvProductPrice.text = format.format(currentItem.giaMon).toString()
        holder.tvProductName.text = currentItem.tenMon
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateData(newItems: List<MonAn>) {
        this.items = newItems
        notifyDataSetChanged()
    }
}