package com.example.finalproject

// Import necessary Android Room libraries
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Define Room database with Contact entity and version 1
@Database(entities = [(Contact::class)], version = 1)
abstract class ContactRoomDatabase : RoomDatabase() {

    // Abstract function to get the DAO
    abstract fun contactDao(): ContactDao

    companion object {
        // Singleton instance of the database
        private var INSTANCE: ContactRoomDatabase? = null

        // Function to get the database instance
        internal fun getDatabase(context: Context): ContactRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    // Create the database if it does not exist
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ContactRoomDatabase::class.java,
                            "contact_database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
