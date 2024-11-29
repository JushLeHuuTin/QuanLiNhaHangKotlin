package com.example.nhahang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(val context: Context, val items : List<Int>) : RecyclerView.Adapter<ViewPageAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgBanner : ImageView = itemView.findViewById(R.id.imgBanner)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_banner,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.imgBanner.setImageResource(currentItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}