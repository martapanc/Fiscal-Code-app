package com.example.fiscalcode.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fiscalcode.R
import com.example.fiscalcode.ui.main.fragments.ContactsFragment
import com.example.fiscalcode.ui.main.fragments.RecentsFragment
import com.example.fiscalcode.ui.main.fragments.SpeedDialFragment

class TabsPagerAdapter(
    fm: FragmentManager,
    behavior: Int,
    private val mContext: Context
) : FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SpeedDialFragment.newInstance()
            1 -> RecentsFragment.newInstance()
            2 -> ContactsFragment.newInstance()
            else -> SpeedDialFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources
            .getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }

    companion object {
        @StringRes
        private val TAB_TITLES =
            intArrayOf(R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3)
    }

}