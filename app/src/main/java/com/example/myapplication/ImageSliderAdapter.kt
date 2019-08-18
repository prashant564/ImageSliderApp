package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.image_slider_item.view.*

class ImageSliderAdapter(private val context: Context) : PagerAdapter() {


    private var inflater: LayoutInflater? = null
    private val images = arrayOf(R.drawable.anton, R.drawable.frankjpg, R.drawable.redcharlie, R.drawable.westboundary)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun getCount(): Int {

        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.image_slider_item, null)
        view.imageView_slide.setImageResource(images[position])

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }

}