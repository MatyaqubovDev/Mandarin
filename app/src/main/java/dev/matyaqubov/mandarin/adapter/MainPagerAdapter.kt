package dev.matyaqubov.mandarin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import dev.matyaqubov.mandarin.R
import dev.matyaqubov.mandarin.model.Page

class MainPagerAdapter(val pages: List<Page>, val mContext: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.item_pager, container, false)

        view.findViewById<TextView>(R.id.tv_title).text = pages[position].title
        view.findViewById<TextView>(R.id.tv_description).text = pages[position].description

        (container as ViewPager).addView(view)

        return view

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

    override fun getCount(): Int = pages.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}