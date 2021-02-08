package com.example.application

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOp) {
            editText.setText("")
        }
        isNewOp = false

        var butClick: String = editText.text.toString()
        var butSelect: Button = view as Button

        when (butSelect.id) {
            but0.id -> {
                butClick += "0"
            }
            but1.id -> {
                butClick += "1"
            }
            but2.id -> {
                butClick += "2"
            }
            but3.id -> {
                butClick += "3"
            }
            but4.id -> {
                butClick += "4"
            }
            but5.id -> {
                butClick += "5"
            }
            but6.id -> {
                butClick += "6"
            }
            but7.id -> {
                butClick += "7"
            }
            but8.id -> {
                butClick += "8"
            }
            but9.id -> {
                butClick += "9"
            }
            butDot.id -> {
                butClick += ","
            }
            butPlusMinus.id -> {
                butClick = "-$butClick"
            }
        }
        editText.setText(butClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText.text.toString()
        var butSelect: Button = view as Button

        when (butSelect.id) {
            butMult.id -> {
                op = "*"
            }
            butPlus.id -> {
                op = "+"
            }
            butMinus.id -> {
                op = "-"
            }
            butDiv.id -> {
                op = "/"
            }
        }

    }

    fun equalEvent(view: View) {
        var newNumber: String = editText.text.toString()
        var result = 0.0

        if (oldNumber != "") {
            when (op) {
                "+" -> {
                    result = oldNumber.toDouble() + newNumber.toDouble()
                }
                "*" -> {
                    result = oldNumber.toDouble() * newNumber.toDouble()
                }
                "/" -> {
                    result = oldNumber.toDouble() / newNumber.toDouble()
                }
                "-" -> {
                    result = oldNumber.toDouble() - newNumber.toDouble()
                }
            }
            editText.setText(result.toString())
        }
    }

    fun acEvent(view: View) {
        editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var no = editText.text.toString().toDouble() / 100
        editText.setText(no.toString())
        isNewOp = true
    }
}