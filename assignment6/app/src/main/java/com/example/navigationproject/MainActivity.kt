package com.example.navigationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri

// MainActivity serves as the host activity for the fragments in the navigation project
// Implements the OnFragmentInteractionListener interface from Fragment2
class MainActivity : AppCompatActivity(), Fragment2.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Sets the layout for the activity
    }

    // Implementation of the interface method from Fragment2
    // This method can be used to handle interactions between Fragment2 and MainActivity
    override fun onFragmentInteraction(uri: Uri) {
        // Currently empty - Can be used to handle URI-based interactions in the future
    }
}
