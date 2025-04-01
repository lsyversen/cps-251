package com.example.recycleviewwithintentproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewwithintentproject.databinding.ActivitySecondBinding

// SecondActivity receives data from MainActivity and displays it
class SecondActivity : AppCompatActivity() {

    // ViewBinding for accessing views in activity_second.xml
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the first string extra (title) from the Intent and display it
        val dataReceived = intent.getStringExtra("input1")
        binding.textView.text = dataReceived ?: "No data received"

        // Get the second string extra (detail) from the Intent and display it
        val dataReceived2 = intent.getStringExtra("input2")
        binding.textView2.text = dataReceived2 ?: "No data received"

        // Get the third string extra (image reference), but always set a default image for now
        val dataReceived3 = intent.getStringExtra("input3")
        binding.imageView.setImageResource(R.drawable.android_image_2) // Static image is used

        // Set click listener on the imageView to send a response back to MainActivity
        binding.imageView.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("response", "Response from SecondActivity")
            }
            setResult(RESULT_OK, returnIntent)
            finish() // Finish and return to MainActivity
        }
    }
}
