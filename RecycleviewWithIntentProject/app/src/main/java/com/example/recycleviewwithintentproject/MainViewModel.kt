package com.example.recycleviewwithintentproject

import androidx.lifecycle.ViewModel

// ViewModel class to hold and manage UI-related data for the RecyclerView
class MainViewModel : ViewModel() {

    // Initial dummy data for titles, details, and image resource IDs
    public var titles: Array<String> = arrayOf("a", "b", "c", "d", "e", "f", "g", "h")
    public var details: Array<String> = arrayOf("a", "b", "c", "d", "e", "f", "g", "h")
    public var images: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    // Populates the 'titles' array with shuffled values from the Data object
    fun populateTitles(data: Data) {
        titles = data.titles.copyOf() // Copy original titles
        for (element in titles) {
            val randomNum = (0..7).random() // Generate random index
            titles[randomNum] = element // Replace random position with current element
        }
    }

    // Populates the 'details' array with shuffled values from the Data object
    fun populateDetails(data: Data) {
        details = data.details.copyOf() // Copy original details
        for (element in details) {
            val randomNum = (0..7).random() // Generate random index
            details[randomNum] = element // Replace random position with current element
        }
    }

    // Populates the 'images' array with shuffled values from the Data object
    fun populateImages(data: Data) {
        images = data.images.copyOf() // Copy original image IDs
        for (element in images) {
            val randomNum = (0..7).random() // Generate random index
            images[randomNum] = element // Replace random position with current image
        }
    }
}
