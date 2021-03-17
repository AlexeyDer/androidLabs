package com.example.database.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.R
import com.example.database.data.Student
import com.example.database.data.StudentViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)


        val us = mutableListOf(
            Student(name = "John", weight = "83", growth = "174", age = 25),
            Student(name = "Markus", weight = "73", growth = "186", age = 20),
            Student(name = "Sam", weight = "95", growth = "196", age = 35),
            Student(name = "Alex", weight = "67", growth = "169", age = 18)
        )

        us.forEach { mStudentViewModel.addStudent(it) }


        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })
//
//        view.floatingActionButton.setOnClickListener {
//            findNavController().navigate(R.id.action_listFragment_to_addFragment)
//        }

        return view
    }

}