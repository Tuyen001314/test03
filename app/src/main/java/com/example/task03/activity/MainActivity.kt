package com.example.task03.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.task03.R
import com.example.task03.adapter.ViewPagerAdapter
import com.example.task03.databinding.ActivityMainBinding
import com.example.task03.fragment.CategoriesFragment
import com.example.task03.fragment.HomeFragment


import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    private var state = 0;
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.hiddenPopUp.setOnClickListener {
            binding.apply {
                drawerLayout.visibility = View.VISIBLE
                popupWindowBackground.visibility = View.INVISIBLE
            }
        }
        addViewPager()

        binding.apply {

            navView.setNavigationItemSelectedListener(this@MainActivity)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun addViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "home")
        adapter.addFragment(CategoriesFragment(), "categories")
        binding.apply {
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
            searchHome.setOnClickListener {
                hamburgerIcon.setImageDrawable(getDrawable(R.drawable.abc_ic_ab_back_material))
                searchHome.visibility = View.INVISIBLE
                textWallpapers.visibility = View.INVISIBLE
                searchView.visibility = View.VISIBLE
                cardViewZ10.visibility = View.INVISIBLE
                cardViewZ101.visibility = View.VISIBLE
                searchHome.visibility = View.INVISIBLE
                state = 1;
                //val search: SearchView.SearchAutoComplete
            }


            hamburgerIcon.setOnClickListener {
                if (state == 0) {
                    binding.drawerLayout.openDrawer(GravityCompat.START)
                    // }
                } else {
                    hamburgerIcon.setImageDrawable(getDrawable(R.drawable.ic_baseline_dehaze_24))
                    searchHome.visibility = View.VISIBLE
                    searchView.visibility = View.INVISIBLE
                    cardViewZ10.visibility = View.VISIBLE
                    cardViewZ101.visibility = View.INVISIBLE
                    textWallpapers.visibility = View.VISIBLE

                    state = 0

                }
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                //startActivity(Intent(this, SettingActivity::class.java))
            }
            R.id.nav_logout -> {

            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

}

