package com.example.nhahang

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerTableAdapter(val context : Context,val items : List<ItemTable>):RecyclerView.Adapter<RecyclerTableAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView :TextView = itemView.findViewById(R.id.tvTable)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerTableAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_table_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerTableAdapter.ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.textView.text = currentItem.name
        if(currentItem.status == 0){
            holder.textView.setBackgroundColor(Color.WHITE)
        }else{
            holder.textView.setBackgroundColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}