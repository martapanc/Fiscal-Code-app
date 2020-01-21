package com.example.fiscalcode.ui.main.compute

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fiscalcode.R
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class ComputeFragment : Fragment() {

    private lateinit var computeViewModel: ComputeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        computeViewModel = ViewModelProviders.of(this).get(ComputeViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_compute, container, false)
        val textView: TextView = root.findViewById(R.id.compute_section_label)
        computeViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })

        val dateOfBirthEditText: EditText = root.findViewById(R.id.dateOfBirth_editText)
        dateOfBirthEditText.setRawInputType(InputType.TYPE_NULL)
        dateOfBirthEditText.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            activity?.let {
                val datePickerDialog =
                    DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, yy, mm, dd ->

                        dateOfBirthEditText.setText("$yy/$mm/$dd")
                        //            lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
                        println(yy)
                        println(mm)
                        println(dd)
                    }, year, month, day)
                datePickerDialog

            }?.show()
        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ComputeFragment {
            return ComputeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
