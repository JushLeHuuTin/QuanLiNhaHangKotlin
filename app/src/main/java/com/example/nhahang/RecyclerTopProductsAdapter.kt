package com.example.nhahang

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerTopProductsAdapter(val context: Context, val items : List<RecyclerTopProductsItem>) : RecyclerView.Adapter<RecyclerTopProductsAdapter.ItemVewHolder>(){
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
        holder.imgProduct.setImageResource(currentItem.imgProduct)
        holder.tvProductPrice.text = currentItem.price?.toString() + "00đ"
        holder.tvProductName.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return items.size
    }
}