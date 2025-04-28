package com.example.finalproject

// Importing necessary Room and LiveData libraries
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// This interface defines database operations for Contact entities
@Dao
interface ContactDao {

    // Insert a new contact into the database
    @Insert
    fun insertContact(contact: Contact)

    // Find contacts whose name contains the given string
    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>

    // Delete a contact by its ID
    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    // Get all contacts as LiveData
    @Query("SELECT * FROM contacts")
    fun getAllContact(): LiveData<List<Contact>>

    // Get all contacts sorted in ascending order by name
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun getAllContactAsc(): LiveData<List<Contact>>

    // Get all contacts sorted in descending order by name
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun getAllContactDesc(): LiveData<List<Contact>>
}
