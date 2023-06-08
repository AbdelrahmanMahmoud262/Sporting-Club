package com.androdevelopment.hsc.Adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androdevelopment.hsc.Models.EventsModel
import com.androdevelopment.hsc.R

class EventsAdapter( val list: MutableList<EventsModel>,var onEventClick: OnEventClick) :
    Adapter<EventsAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)

        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val item = list[position]
        val bitmap = getBitmapFromEncodedString(item.encodedString)

        if (bitmap != null) {
            holder.images.setImageBitmap(bitmap)
        }
        holder.title.text = item.eventName
        holder.date.text = item.eventDate

//        holder.itemView.setOnClickListener {
//            onEventClick.onClick(position,item)
//        }
    }

    private fun getBitmapFromEncodedString(encodedImage: String): Bitmap? {

        val imageBytes = Base64.decode(encodedImage, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        return if (encodedImage.isNotEmpty()){
            decodedImage
        }else{
            null
        }

    }


    inner class EventViewHolder(itemView: View) : ViewHolder(itemView) {

        val images: ImageView = itemView.findViewById(R.id.imageViewEvent)
        val title: TextView = itemView.findViewById(R.id.textViewEventName)
        val date: TextView = itemView.findViewById(R.id.textViewEventDate)

    }


    interface OnEventClick {
        fun onClick(position: Int,item:EventsModel)
    }
}