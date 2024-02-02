package Adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter constructor(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = mutableListOf<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getPageTitle(position: Int): CharSequence? {
        // Return the title for the tab at the specified position
        return when (position) {
            0 -> "Time"
            1 -> "Finance"
            2 -> "Performance"
            3 -> "Help Desk"
            else -> null
        }?.lowercase()
    }
}