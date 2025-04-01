package com.example.recycleviewwithintentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.recycleviewwithintentproject.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// MainActivity is the entry point of the app and sets up the RecyclerView with data
class MainActivity : AppCompatActivity() {
    // ViewModel to manage UI-related data
    private lateinit var viewModel: MainViewModel

    // ViewBinding for accessing layout views
    private lateinit var binding: ActivityMainBinding

    // RecyclerView components
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the activity layout
        setContentView(R.layout.activity_main)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the layout manager for the RecyclerView
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // Get an instance of the ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Load data into the ViewModel
        val data = Data()
        viewModel.populateTitles(data)
        viewModel.populateDetails(data)
        viewModel.populateImages(data)

        // Set up the adapter with the ViewModel and attach it to the RecyclerView
        adapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }
}
