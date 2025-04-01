package com.example.recycleviewwithintentproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewwithintentproject.databinding.CardLayoutBinding

// Adapter for populating RecyclerView with data from MainViewModel
class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // ViewHolder class to hold reference to the views in each item layout
    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // Set click listener for each item in the RecyclerView
            itemView.setOnClickListener { v ->
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Create intent to start SecondActivity and pass item data
                    val intent = Intent(v.context, SecondActivity::class.java).apply {
                        putExtra("input1", binding.itemTitle.text.toString())
                        putExtra("input2", binding.itemDetail.text.toString())
                        putExtra("input3", binding.itemImage.toString()) // Sends imageView as string
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        // Bind data to the views in the item layout
        fun bind(title: String, detail: String, imageResId: Int) {
            binding.itemImage.setImageResource(imageResId)
            binding.itemTitle.text = title
            binding.itemDetail.text = detail
        }
    }

    // Called when a new ViewHolder needs to be created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Binds data to a ViewHolder at a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel.titles[position], viewModel.details[position], viewModel.images[position])
    }

    // Returns the total number of items to be displayed
    override fun getItemCount(): Int = viewModel.titles.size
}
