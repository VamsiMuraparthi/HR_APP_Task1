package com.example.task_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val holidays = arrayOf(
        "Maha Shivaratri", "Holi", "Good Friday", "Ugadi", "Eid AI Fitr", "Ram Navami",
        "Bakrid/Eid al Adha", "Independence Day", "Rakshabandhan", "Krishna Jayanti/Janmashtmi"
    )

    val dates = arrayOf(
        "Fri, 08 March 2024", "Mon, 25 March 2024", "Fri, 29 March 2024", "Tue, 09 April 2024",
        "Wed, 10 April 2024", "Wed, 17 April 2024", "Mon, 17 June 2024", "Thu, 15 August 2024",
        "Mon, 19 August 2024", "Mon, 26 August 2024"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val linearLayout: LinearLayout = view.findViewById(R.id.holidayScrollView)
        val listItem: View = LayoutInflater.from(requireContext()).inflate(R.layout.holiday_fragment, linearLayout, false)
        val holiday: TextView = listItem.findViewById(R.id.holidayText)
        val date: TextView = listItem.findViewById(R.id.dateText)
        for (i in holidays.indices) {
            holiday.text = holidays[i]
            date.text = dates[i]

            // Add the listItem to the horizontalLinearLayout
            linearLayout.addView(listItem)
        }
        return view
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}