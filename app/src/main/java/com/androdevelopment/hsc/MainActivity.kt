package com.androdevelopment.hsc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.androdevelopment.hsc.Fragments.HomeFragment
import com.androdevelopment.hsc.Fragments.MenuFragment
import com.androdevelopment.hsc.Fragments.SportsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var nav: BottomNavigationView


    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.mainToolbar)
        nav = findViewById(R.id.bottomNavigationView)


        setSupportActionBar(toolbar)

        replaceFragment(HomeFragment())

        nav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.sprots -> {
                    replaceFragment(SportsFragment())
                    true
                }

                R.id.menu -> {
                    replaceFragment(MenuFragment())
                    true
                }

                else -> {false}
            }
        }

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