package com.androdevelopment.hsc.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.INVISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androdevelopment.hsc.Models.MenuModel
import com.androdevelopment.hsc.R

class MenuAdapter(val list:MutableList<MenuModel>, val onMenuClick: OnMenuClick): Adapter<MenuAdapter.MenuViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = list[position]

        holder.icon?.setImageResource(item.icon!!)
        holder.title.text = item.title

        for (menu in list){
            if ((menu.collection == item.collection) && (!item.isVisible && !menu.isVisible)){
                holder.collection.text = item.collection
                item.isVisible = true
            }else if (menu.collection == item.collection && menu.isVisible){
                holder.collection.visibility = GONE
            }
        }

        holder.itemView.setOnClickListener { onMenuClick.onMenuClick(item) }

    }

    inner class MenuViewHolder(itemView: View) : ViewHolder(itemView) {

        val icon: ImageView? = itemView.findViewById<ImageView>(R.id.imageViewMenuIcon)
        val title:TextView = itemView.findViewById<TextView>(R.id.textViewMenuTitle)
        val collection:TextView = itemView.findViewById(R.id.textViewMenuCollection)


    }

    interface OnMenuClick{
        fun onMenuClick(item:MenuModel)
    }
}