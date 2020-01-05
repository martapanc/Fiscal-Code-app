package com.example.fiscalcode.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fiscalcode.R
import com.example.fiscalcode.ui.main.PageViewModel

class SpeedDialFragment : Fragment() {
    private var pageViewModel: PageViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java)
        pageViewModel!!.setIndex("Speed dial fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView = root.findViewById<TextView>(R.id.section_label)
        pageViewModel!!.text.observe(this, Observer { s -> textView.text = s })
        return root
    }

    companion object {
        private const val TAG = "SpeedDial"
        /**
         * @return A new instance of fragment SpeedDialFragment.
         */
        fun newInstance(): SpeedDialFragment {
            return SpeedDialFragment()
        }
    }
}