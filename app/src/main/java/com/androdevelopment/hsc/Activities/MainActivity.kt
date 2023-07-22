package com.androdevelopment.hsc.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.androdevelopment.hsc.Fragments.HomeFragment
import com.androdevelopment.hsc.Fragments.MenuFragment
import com.androdevelopment.hsc.Fragments.SportsFragment
import com.androdevelopment.hsc.R
import com.androdevelopment.hsc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)
        binding.appBar.liftOnScrollTargetViewId = R.id.scrollViewHome

        setupBottomNavigation()
        populateContent()
        setListeners()

    }

    private fun setListeners() {

        binding.profileHome.setOnClickListener {
            startActivity(Intent(this@MainActivity,Profile::class.java))
        }
    }

    private fun setupBottomNavigation() {
        with(binding.bottomNavigationView) {
            setOnItemSelectedListener { menuItem ->
                val (fragment, liftOnScrollId) = when (menuItem.itemId) {
                    R.id.home -> HomeFragment() to R.id.scrollViewHome
                    R.id.sprots -> SportsFragment() to R.id.scrollViewHome
                    R.id.menu -> MenuFragment() to R.id.recyclerMenu
                    else -> HomeFragment() to R.id.scrollViewHome
                }

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout,fragment)
                    .commit()

                binding.appBar.liftOnScrollTargetViewId = liftOnScrollId

                true
            }
        }
    }

    private fun populateContent() {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout,HomeFragment())
                .commit()
            binding.appBar.liftOnScrollTargetViewId = R.id.scrollViewHome

    }


    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.setCustomAnimations(
            android.R.anim.slide_in_left,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.slide_out_right
        )
        transaction.commit()
    }
}