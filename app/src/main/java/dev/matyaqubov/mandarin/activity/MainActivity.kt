package dev.matyaqubov.mandarin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.matyaqubov.mandarin.R
import dev.matyaqubov.mandarin.adapter.MainPagerAdapter
import dev.matyaqubov.mandarin.model.Page

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pages: ArrayList<Page>
    private lateinit var mainPagerAdapter: MainPagerAdapter
    private lateinit var mainTab: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pages = addPages()

        initViews()


    }

    private fun addPages(): ArrayList<Page> {
        return ArrayList<Page>().apply {
            for (i in 0..2) {
                this.add(
                    Page("All Your Favourite Dishes",
                    "Hi, My friends, Would you like to eat a delicious meal in restaurant")
                )
            }
        }
    }

    private fun initViews() {

        viewPager = findViewById(R.id.vp_main)
        mainTab = findViewById(R.id.tab_main)

        mainPagerAdapter = MainPagerAdapter(pages, this)
        viewPager.adapter = mainPagerAdapter
        mainTab.setupWithViewPager(viewPager)

    }
}