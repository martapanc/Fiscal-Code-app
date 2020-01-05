package com.example.fiscalcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.fiscalcode.ui.main.TabsPagerAdapter
import com.google.android.material.tabs.TabLayout

class MA2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabsPagerAdapter = TabsPagerAdapter(supportFragmentManager, 1, this)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = tabsPagerAdapter
        val tabs = findViewById<TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}