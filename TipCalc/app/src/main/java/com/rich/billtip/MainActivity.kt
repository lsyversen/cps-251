package com.rich.billtip

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val btn = findViewById<Button>(R.id.button)  // Button to calculate tip
        val editText = findViewById<EditText>(R.id.editTextNumber)  // Input field for bill amount
        val textView = findViewById<TextView>(R.id.textView)  // TextView to display the result

        // Set click listener for the button
        btn.setOnClickListener {
            val bill = editText.text.toString().toDoubleOrNull()  // Convert input to Double

            // Check if the input is valid
            textView.text = if (bill != null && bill > 0) {
                // Calculate tip amounts
                val tip10 = bill + bill * 0.1
                val tip15 = bill + bill * 0.15
                val tip20 = bill * 1.2

                // Display calculated tip amounts
                StringBuilder().apply {
                    appendLine("The tips are as follows:")
                    appendLine("10% = $tip10")
                    appendLine("15% = $tip15")
                    append("20% = $tip20")
                }
            } else {
                // Display error message if input is invalid
                "YOU MUST ENTER A BILL AMOUNT"
            }
        }
    }
}
