package com.example.database.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.database.R
import com.example.database.data.Student
import com.example.database.data.StudentViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = name_et.text.toString()
        val weight = weight_et.text.toString()
        val glow = glow_et.text.toString()
        val age = age_et.text

        if (inputCheck(name, weight, glow, age)) {

            val student = Student(0, name, weight, glow, Integer.parseInt(age.toString()))

            mStudentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Студент успешно добавлен!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Пожалуйста, заполните все поля!", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(name: String, weight: String, glow: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(weight) && TextUtils.isEmpty(glow)
                && age.isEmpty())
    }

}