package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.databinding.Fragment1Binding
import androidx.navigation.Navigation

// Fragment1 class represents a UI fragment in the navigation project
class Fragment1 : Fragment() {

    // View binding instance to access UI elements safely
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!! // Ensures non-null access to binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using View Binding and return the root view
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set images for ImageView components
        binding.imageView.setImageResource(R.drawable.android_image_1)
        binding.imageView2.setImageResource(R.drawable.android_image_2)
        binding.imageView3.setImageResource(R.drawable.android_image_3)

        // Set click listener for button1 to navigate to the second fragment
        binding.button1.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 1" // Pass text information
            action.imageNumber = R.drawable.android_image_1.toString() // Pass image as string
            Navigation.findNavController(it).navigate(action) // Navigate to Fragment2
        }

        // Set click listener for button2 to navigate with image 2 details
        binding.button2.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 2"
            action.imageNumber = R.drawable.android_image_2.toString()
            Navigation.findNavController(it).navigate(action)
        }

        // Set click listener for button3 to navigate with image 3 details
        binding.button3.setOnClickListener {
            val action: Fragment1Directions.MainToSecond = Fragment1Directions.mainToSecond()
            action.textBox = "Image 3"
            action.imageNumber = R.drawable.android_image_3.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks by clearing binding reference
    }
}
