package com.example.coroutinesproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

// ViewModel to manage UI-related data and handle background operations
class MainViewModel : ViewModel() {

    // Stores the formatted entry string
    private var entry: String = ""

    // Stores the random delay time in milliseconds
    private var time = 0L

    // List to hold formatted name entries
    val listOfNames = arrayListOf<String>()

    // Suspend function to simulate a delayed background task that adds a formatted name to the list
    suspend fun addNames(input: String) {
        // Generate a random delay between 1 and 10 seconds
        time = (1..10).random().toLong() * 1000

        // Suspend the coroutine for the randomly generated delay
        delay(time)

        // Create a formatted string with the input name and delay duration
        entry = "The name is $input and the delay is $time milliseconds"

        // Add the entry to the list of names
        listOfNames.add(entry)
    }
}
