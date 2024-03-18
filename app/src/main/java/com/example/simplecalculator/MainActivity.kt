package com.example.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var editTextValue1: EditText
    private lateinit var editTextValue2: EditText
    private lateinit var textViewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout)
        editTextValue1 = findViewById(R.id.editTextValue1)
        editTextValue2 = findViewById(R.id.editTextValue2)
        textViewResult = findViewById(R.id.textViewResult)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener {
            calculateResult('+')
        }

        buttonSubtract.setOnClickListener {
            calculateResult('-')
        }

        buttonMultiply.setOnClickListener {
            calculateResult('*')
        }

        buttonDivide.setOnClickListener {
            calculateResult('/')
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateResult(operator: Char) {
        val value1Str = editTextValue1.text.toString()
        val value2Str = editTextValue2.text.toString()

        if (value1Str.isNotEmpty() && value2Str.isNotEmpty()) {
            val value1 = value1Str.toDouble()
            val value2 = value2Str.toDouble()

            val result = when (operator) {
                '+' -> value1 + value2
                '-' -> value1 - value2
                '*' -> value1 * value2
                '/' -> if (value2 != 0.0) value1 / value2 else Double.NaN
                else -> Double.NaN
            }

            textViewResult.text = "Result: $result"
        } else {
            textViewResult.text = "Please enter both values"
        }
    }
}
