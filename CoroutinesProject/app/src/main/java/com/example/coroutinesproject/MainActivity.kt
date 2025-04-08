package com.example.coroutinesproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// MainActivity is the entry point of the app's UI
class MainActivity : AppCompatActivity() {

    // ViewModel to handle UI-related data
    private lateinit var viewModel: MainViewModel

    // Coroutine job to manage background tasks
    private var job: Job? = null

    // View binding object to access layout views
    private lateinit var binding: ActivityMainBinding

    // LayoutManager for arranging items in the RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null

    // Adapter to connect RecyclerView with data
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    @SuppressLint("NotifyDataSetChanged") // Suppress warning about directly calling notifyDataSetChanged()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView with a linear layout
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Get references to input EditText and Button from layout
        val input = findViewById<EditText>(R.id.textInput)
        val button = findViewById<Button>(R.id.button)

        // Set click listener on the button
        button.setOnClickListener {
            // Only launch the coroutine if no job is currently running
            if (job == null || job?.isActive != true) {
                // Launch a coroutine on the Main thread
                job = CoroutineScope(Dispatchers.Main).launch {
                    // Call ViewModel method to add name to list
                    viewModel.addNames(input.text.toString())

                    // Notify adapter that the data set has changed
                    adapter?.notifyDataSetChanged()
                }
            }
        }

        // Initialize and attach the adapter to RecyclerView
        adapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }
}
