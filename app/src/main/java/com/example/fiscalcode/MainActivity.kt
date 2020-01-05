package com.example.fiscalcode

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.fiscalcode.ui.main.SectionsPagerAdapter
import com.example.fiscalcode.ui.main.TabsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabsPagerAdapter = TabsPagerAdapter(supportFragmentManager, 1, this)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)

//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionsPagerAdapter

        viewPager.adapter = tabsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val tabsPagerAdapter = TabsPagerAdapter(supportFragmentManager, 1, this)
//        val viewPager = findViewById<ViewPager>(R.id.view_pager)
//        viewPager.adapter = tabsPagerAdapter
//        val tabs = findViewById<TabLayout>(R.id.tabs)
//        tabs.setupWithViewPager(viewPager)
//    }
    }
}