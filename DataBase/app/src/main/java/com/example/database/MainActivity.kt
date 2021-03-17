package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.database.data.Student
import com.example.database.fragments.FirstFragment
import com.example.database.fragments.MyPagerAdapter
import com.example.database.fragments.list.ListFragment
import com.example.database.fragments.table.TableFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
//        setupActionBarWithNavController(findNavController(R.id.fragment_list))
    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment_list)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

    private fun setUpTabs() {
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(FirstFragment(), "Image")
        fragmentAdapter.addFragment(ListFragment(), "List")
        fragmentAdapter.addFragment(TableFragment(), "Table")

        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_launcher_background)
    }

}