package com.example.task_1

import Adapters.RecyclerViewAdapter
import DataModels.ItemDataModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class homeActivity : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var recyclerView: RecyclerView
    private var dataList: ArrayList<ItemDataModel> = ArrayList()

    lateinit var employee_images : Array<Int>
    lateinit var employee_names : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

//        val linearLayout: LinearLayout = view.findViewById(R.id.holidayScrollView)
//
//        for (i in holidays.indices) {
//            val listItem: View = LayoutInflater.from(requireContext()).inflate(R.layout.holiday_fragment, linearLayout, false)
//            val holiday: TextView = listItem.findViewById(R.id.holidayText)
//            val date: TextView = listItem.findViewById(R.id.dateText)
//
//            holiday.text = holidays[i]
//            date.text = dates[i]
//
//            linearLayout.addView(listItem)
//        }
//        return view
        employee_images = arrayOf(
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
        )

        employee_names = arrayOf(
            "Person 1",
            "Person 2",
            "Person 3",
            "Person 4",
            "Person 5",
            "Person 6",
            "Person 7"
        )

        getData()

        val recyclerView1: RecyclerView = view.findViewById(R.id.image_recyclerView)
        val recyclerView2: RecyclerView = view.findViewById(R.id.wish_them_recyclerView)


        val adapter = RecyclerViewAdapter(dataList)

        recyclerView1.adapter = adapter
        recyclerView1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        recyclerView2.adapter = adapter
        recyclerView2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        return view
    }

    private fun getData() {
        for (i in employee_images.indices) {
            val dataClass = ItemDataModel(employee_images[i], employee_names[i])
            dataList.add(dataClass)
        }
    }


        companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homeActivity().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}