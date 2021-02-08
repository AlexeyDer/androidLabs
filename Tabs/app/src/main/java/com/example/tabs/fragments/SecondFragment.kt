package com.example.tabs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tabs.R
import kotlinx.android.synthetic.main.activity_main.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView: ListView = findViewById(R.id.listView)

        val catNames = arrayOf<String?>(
            "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
            "Китти", "Масяня", "Симба"
        )

        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            R.layout.fragment_second, catNames
        )

        listView.setAdapter(adapter)

        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


}