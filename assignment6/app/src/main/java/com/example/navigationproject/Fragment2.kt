package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.databinding.Fragment2Binding
import android.net.Uri

// Fragment2 class represents the second fragment in the navigation project
class Fragment2 : Fragment() {

    // Interface for fragment interaction (potentially used for communication with an activity)
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    // View binding instance for accessing UI elements
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!! // Ensures safe non-null access

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using View Binding and return the root view
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        // Retrieve arguments passed from Fragment1
        arguments?.let {
            val argsText = Fragment2Args.fromBundle(it) // Extract arguments using Safe Args
            binding.textView.text = argsText.textBox // Set the passed text in the TextView

            // Convert the imageNumber argument to an integer and set the corresponding image
            val argsImage = argsText.imageNumber.toIntOrNull() ?: 0
            binding.imageView4.setImageResource(argsImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks by clearing the binding reference
    }
}
