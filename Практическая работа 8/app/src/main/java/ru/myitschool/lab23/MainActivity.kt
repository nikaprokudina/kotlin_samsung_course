package ru.myitschool.lab23

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSideA: EditText
    private lateinit var editTextSideB: EditText
    private lateinit var editTextSideC: EditText
    private lateinit var spinner: Spinner
    private lateinit var textViewSolution: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSideA = findViewById(R.id.side_a)
        editTextSideB = findViewById(R.id.side_b)
        editTextSideC = findViewById(R.id.side_c)
        spinner = findViewById(R.id.spinner)
        textViewSolution = findViewById(R.id.solution)

        val adapter = ArrayAdapter.createFromResource(this,
            R.array.calculation_options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        findViewById<View>(R.id.calculate).setOnClickListener { calculate() }
        textViewSolution.setOnClickListener { copyToClipboard(textViewSolution.text.toString()) }
    }

    private fun calculate() {
        val sideA = editTextSideA.text.toString().toDouble()
        val sideB = editTextSideB.text.toString().toDouble()
        val sideC = editTextSideC.text.toString().toDouble()

        val result = when (spinner.selectedItemPosition) {
            0-> sideA + sideB + sideC
            1-> Math.sqrt(sideA * sideA + sideB * sideB + sideC * sideC)
            2-> 2 * (sideA * sideB + sideB * sideC + sideC * sideA)
            3-> sideA * sideB * sideC
            else -> 0.0
        }

        textViewSolution.text = String.format("%.5f", result)
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.setPrimaryClip(clip)
    }
}
