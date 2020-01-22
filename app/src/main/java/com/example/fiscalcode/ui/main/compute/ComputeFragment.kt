package com.example.fiscalcode.ui.main.compute

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fiscalcode.R
import org.json.JSONObject
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


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

        Locale.setDefault(Locale.ITALY)

        val dateOfBirthEditText: EditText = root.findViewById(R.id.dateOfBirth_editText)
        dateOfBirthEditText.setRawInputType(InputType.TYPE_NULL)
        dateOfBirthEditText.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            c.add(Calendar.YEAR, -120)

            val datePickerDialog = activity?.let { it ->
                DatePickerDialog(it,
                    DatePickerDialog.OnDateSetListener { _, yy, mm, dd ->
                        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ITALY)
                        val calendar = Calendar.getInstance()
                        calendar.set(yy, mm, dd)
                        dateOfBirthEditText.setText(sdf.format(calendar.time))
                    }, year, month, day)
            }
            datePickerDialog?.datePicker?.maxDate = System.currentTimeMillis()
            datePickerDialog?.setTitle(getString(R.string.dateOfBirth_title))
            datePickerDialog?.datePicker?.minDate = c.timeInMillis
            datePickerDialog?.show()
        }

        val obj = JSONObject(readJSONFromAsset())
//        val list = obj.getJSONArray("comuni")
//
////        val townList = ArrayList<String>()
//        for (i in 0 until list.length()) {
//            val town : JSONObject = list.getJSONObject(i)
//            println(town.getString("name"))
////            townList.add(town.getString("name"))
//        }

        println(obj.getJSONArray("comuni"))


        val autotextView = root.findViewById<AutoCompleteTextView>(R.id.placeOfBirth_autocompleteTextView)
        val adapter = activity?.let { it -> ArrayAdapter(it, android.R.layout.simple_list_item_1, COUNTRIES)}
        autotextView.setAdapter(adapter)


        return root
    }


//    private val comuniJson = URL("https://raw.githubusercontent.com/matteocontrini/comuni-json/master/comuni.json").readText()


    private val COUNTRIES = arrayOf(
        "Belgium", "France", "Italy", "Italian", "Ithaca", "Germany", "Spain"
    )

    private fun readJSONFromAsset(): String? {
        val json: String?
        try {
            val  inputStream: InputStream? = context?.assets?.open("comuni.json")
            json = inputStream?.bufferedReader().use{it?.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
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
