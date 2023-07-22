package com.androdevelopment.hsc.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androdevelopment.hsc.Models.SportModel
import com.androdevelopment.hsc.R
import com.androdevelopment.hsc.databinding.ItemSportsBinding

class SportsAdapter(val list:ArrayList<SportModel>): Adapter<SportsAdapter.SportsViewHolder>() {

    private lateinit var binding:ItemSportsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        binding = ItemSportsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SportsViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {

        val item = list[position]

        binding.sportName.text = item.name

    }

    inner class SportsViewHolder(viewBinding: ItemSportsBinding) : ViewHolder(viewBinding.root)

}