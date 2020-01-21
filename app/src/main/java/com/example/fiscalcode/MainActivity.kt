package com.example.fiscalcode

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.fiscalcode.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
//
//        val dateOfBirth_editText: EditText = findViewById(R.id.dateOfBirth_editText)
//        dateOfBirth_editText.setRawInputType(InputType.TYPE_NULL)
//        dateOfBirth_editText.setOnClickListener {
//            val calendar = Calendar.getInstance()
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            val month = calendar.get(Calendar.MONTH)
//            val year = calendar.get(Calendar.YEAR)
//
//            val picker = DatePickerDialog(this@MainActivity,
//                DatePickerDialog.OnDateSetListener { view, yearCal, monthOfYear, dayOfMonth ->
//                    println(dayOfMonth)
//                    println(monthOfYear)
//                    println(yearCal)
//                }, year, month, day)
//            picker.show()
//        }

    }
}