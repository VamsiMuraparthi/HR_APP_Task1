package com.example.task_1

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.task_1.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: Fragment
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeActivity())

        setSupportActionBar(binding.toolbar)


        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.custom_drawer_icon)
        }


        binding.navigationDrawer.setNavigationItemSelectedListener (this)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(homeActivity())
                R.id.inbox -> replaceFragment(InboxActivity())
                R.id.me -> replaceFragment(meActivity())
                R.id.myTeam -> replaceFragment(myteamActivity())

                else -> {

                }
            }
            true
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.company_name -> {
                Toast.makeText(this, "Keka Technologies", Toast.LENGTH_SHORT).show()
            }
            R.id.language ->{
                Toast.makeText(this, "You can change language", Toast.LENGTH_SHORT).show()
            }
            R.id.theme ->{
                Toast.makeText(this, "You can change theme", Toast.LENGTH_SHORT).show()
            }
            R.id.secure -> {
                Toast.makeText(this, "You are secured", Toast.LENGTH_SHORT).show()
            }
            R.id.logout -> {
                Toast.makeText(this, "You can logout", Toast.LENGTH_SHORT).show()
            }

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container, fragment)
        fragmentTransition.commit()
    }
}