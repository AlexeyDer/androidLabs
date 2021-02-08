package com.example.tabs

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tabs.fragments.FirstFragment
import com.example.tabs.fragments.SecondFragment
import com.example.tabs.fragments.ThirdFragment
import com.example.tabs.fragments.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    private fun setUpTabs() {
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager         )
        fragmentAdapter.addFragment(FirstFragment(), "First")
        fragmentAdapter.addFragment(SecondFragment(), "Second")
        fragmentAdapter.addFragment(ThirdFragment(), "Third")


        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_accessibility_24)

    }
}

