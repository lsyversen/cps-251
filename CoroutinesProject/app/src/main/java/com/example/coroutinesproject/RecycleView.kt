package com.example.coroutinesproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesproject.databinding.CardLayoutBinding

// RecyclerView Adapter to display a list of names from the MainViewModel
class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // ViewHolder class to hold and bind views for each item in the RecyclerView
    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Binds a string (name entry) to the TextView in the card layout
        fun bind(listOfNames: String) {
            binding.nameResults.text = listOfNames
        }
    }

    // Called when the RecyclerView needs a new ViewHolder to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the card layout using view binding
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Binds the data at the given position to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel.listOfNames[position])
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int = viewModel.listOfNames.size
}