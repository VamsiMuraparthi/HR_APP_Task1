package com.example.task_1

import Adapters.TabsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.task_1.MeFragmentTabs.FinanceTabActivity
import com.example.task_1.MeFragmentTabs.HelpDeskTabActivity
import com.example.task_1.MeFragmentTabs.PerformanceTabActivity
import com.example.task_1.MeFragmentTabs.TimeTabActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class meActivity : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: TabsAdapter

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
        val view = inflater.inflate(R.layout.fragment_me, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        adapter = TabsAdapter(this)

        val fragments  = arrayOf(FinanceTabActivity(),HelpDeskTabActivity(),PerformanceTabActivity(),TimeTabActivity())

        viewPager.adapter = TabsAdapter(this)

        adapter.addFragment(TimeTabActivity())
        adapter.addFragment(FinanceTabActivity())
        adapter.addFragment(PerformanceTabActivity())
        adapter.addFragment(HelpDeskTabActivity())

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        return view

//        val linearLayout: LinearLayout = view.findViewById(R.id.horizontalLinearLayout)
//
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
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            meActivity().apply {

            }
    }
}