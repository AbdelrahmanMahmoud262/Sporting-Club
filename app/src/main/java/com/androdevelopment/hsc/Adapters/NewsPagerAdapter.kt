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
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.androdevelopment.hsc.Models.NewsModel
import com.androdevelopment.hsc.R


class NewsPagerAdapter(private val context: Context, private val list: List<NewsModel>) : PagerAdapter() {


    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.item_news, null
            )


        val image = view.findViewById<ImageView>(R.id.imageViewNews)
        val text = view.findViewById<TextView>(R.id.textViewNewsTitle)

        val item = list[position]

        val bitmap: Bitmap? = getBitmapFromEncodedString(item.encodedString)

        image.setImageBitmap(bitmap)
        text.text = item.title


        val vp = container as ViewPager
        vp.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }


    private fun getBitmapFromEncodedString(encodedImage: String): Bitmap? {

        val imageBytes = Base64.decode(encodedImage, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        return if (encodedImage.isNotEmpty()) {
            decodedImage
        } else {
            null
        }

    }


}