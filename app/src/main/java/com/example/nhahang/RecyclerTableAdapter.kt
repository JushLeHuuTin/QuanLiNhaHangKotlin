package com.example.nhahang

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerTableAdapter(val context : Context,val items : List<ItemTable>):RecyclerView.Adapter<RecyclerTableAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView :TextView = itemView.findViewById(R.id.tvTable)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_table_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.textView.text = currentItem.name
        if(currentItem.status == 0){
            holder.textView.setBackgroundResource(R.drawable.shape_empty_table)
        }else{
            holder.textView.setBackgroundResource(R.drawable.shape_occupied_table)
        }
        holder.itemView.setOnClickListener {
            when(currentItem.status){
                0->{
                    Toast.makeText(context,"Bàn trống", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context,GoiMonActivity::class.java)
                    intent.putExtra("TableName",currentItem.name)
                    context.startActivity(intent)
                }
                1->{
                    Toast.makeText(context,"Bàn có khách", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context,GioHangActivity::class.java)
                    intent.putExtra("TableName",currentItem.name)
                    context.startActivity(intent)

                }

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}