package com.example.finalproject

// Import necessary libraries
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

// Repository class to handle data operations for contacts
class ContactRepository(application: Application) {

    // LiveData to hold search results
    val searchResults = MutableLiveData<List<Contact>>()

    // Data Access Object for contacts
    private var contactDao: ContactDao?

    // Coroutine scope for background tasks
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    // LiveData to observe all contacts
    val allContacts: LiveData<List<Contact>>?

    // Initialize the database and DAO
    init {
        val db: ContactRoomDatabase? = ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContact()
    }

    // Insert a new contact using coroutine
    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    // Actual insertion operation in background
    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    // Delete a contact by ID using coroutine
    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    // Actual delete operation in background
    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    // Search for contacts by name
    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    // Helper function to search for contacts asynchronously
    // (uses Deferred to return a value back to await)
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            // Return the search result
            return@async contactDao?.findContact(name)
        }

    // Retrieve all contacts
    fun getAllContact(): LiveData<List<Contact>> {
        return contactDao?.getAllContact() ?: MutableLiveData(emptyList())
    }

    // Retrieve contacts sorted in ascending order
    fun getAllContactAsc(): LiveData<List<Contact>> {
        return contactDao?.getAllContactAsc() ?: MutableLiveData(emptyList())
    }

    // Retrieve contacts sorted in descending order
    fun getAllContactDesc(): LiveData<List<Contact>> {
        return contactDao?.getAllContactDesc() ?: MutableLiveData(emptyList())
    }
}
