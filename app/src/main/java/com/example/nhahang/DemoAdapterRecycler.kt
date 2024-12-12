package com.example.nhahang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DemoAdapterRecycler(val context : Context, val items : List<RecyclerItem>) : RecyclerView.Adapter<DemoAdapterRecycler.ItemViewHolder>() {
    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.img_topnav)
        val textView : TextView = view.findViewById(R.id.tv_topnav)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater : LayoutInflater =  LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item,parent,false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.img);
        holder.textView.text = item.title
    }

    override fun getItemCount(): Int {
        return items.size
    }
}