package com.example.database.fragments.table

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.R
import com.example.database.data.Student
import com.example.database.data.StudentViewModel
import com.example.database.fragments.list.ListAdapter
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_table.*
import kotlin.random.Random

class TableFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_table, container, false)

        val tableLayout: TableLayout = view.findViewById(R.id.table_db)

        val lp = TableRow.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.MATCH_PARENT
        )

        lp.bottomMargin = 32
        lp.topMargin = 32
        val row: TableRow = TableRow(tableLayout.context)
        row.layoutParams = lp
        row.gravity = Gravity.CENTER
        for (i in 0..3) {
            val tv = TextView(context)
            val lpb = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT
            )
            lpb.leftMargin = 32
            lpb.rightMargin = 32
            lpb.gravity = Gravity.CENTER
            tv.layoutParams = lpb
            when (i) {
                0 -> tv.text = String.format("Имя")
                1 -> tv.text = String.format("Вес")
                2 -> tv.text = String.format("Рост")
                3 -> tv.text = String.format("Возраст")
            }
            tv.setTextColor(Color.BLACK)
            row.addView(tv)
        }
        tableLayout.addView(row)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { students ->
            students.forEach { it ->
                val lp = TableRow.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT
                )
                lp.bottomMargin = 32
                lp.topMargin = 32
                var row: TableRow = TableRow(tableLayout.context)
                row.layoutParams = lp
                row.gravity = Gravity.CENTER


                for (i in 0..3) {
                    val tv = TextView(context)
                    val lpb = TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT
                    )
                    lpb.gravity = Gravity.CENTER
                    lpb.leftMargin = 32
                    lpb.rightMargin = 32
                    tv.layoutParams = lpb
                    when (i) {
                        0 -> tv.text = String.format("%s", it.name)
                        1 -> tv.text = String.format("%s", it.weight)
                        2 -> tv.text = String.format("%s", it.growth)
                        3 -> tv.text = String.format("%d", it.age)
                    }
                    tv.setTextColor(Color.BLACK)
                    row.addView(tv)
                }
                tableLayout.addView(row)
            }
        })


        return view
    }

    fun getRandomColor(): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        return Pair(
            Pair(Random.nextInt(30, 225), Random.nextInt(30, 225)),
            Pair(Random.nextInt(30, 225), Random.nextInt(30, 225))
        )
    }

}